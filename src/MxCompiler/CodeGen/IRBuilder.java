/*
	Coded by timemachine on 18-5-19
	MxCompiler.CodeGen.IRBuilder
*/


package MxCompiler.CodeGen;

import MxCompiler.AST.*;
import MxCompiler.Entities.FunctionEntity;
import MxCompiler.Entities.ParameterEntity;
import MxCompiler.Entities.Scope;
import MxCompiler.Entities.VariableEntity;
import MxCompiler.Global;
import MxCompiler.IR.*;
import MxCompiler.Options;
import MxCompiler.SemanticCheck.ASTree;
import MxCompiler.Type.*;
import MxCompiler.tools.Debuger;

import java.util.*;

public class IRBuilder extends ASTBaseVisitor
{
	private HashMap<ASTNode, Object>map = new HashMap<>();
	private HashSet<ASTNode>llMap = new HashSet<>();
	private List<InsIR> mainIrList, globalVarInitList;
	private List<GlobalVarIR> globalVars;
	private boolean isGlobal;
	private List<List<InsIR>> irList;
	private List<StringLitIR> constList;
	private ASTree ast;
	private Scope nowScope;
	private int thisReg, savedRegNumber;

	private boolean isLeftValue = false;


	public IRBuilder(ASTree ast)
	{
		this.irList = null;
		this.ast = ast;
		this.constList = new ArrayList<>();
		this.nowScope = ast.mainScope();
		this.globalVars = new ArrayList<>();
	}
	private List<InsIR> getGlobalVarList()
	{
		isGlobal = true;
		List<InsIR> list = new ArrayList<InsIR>();
		for(ASTNode i: ast.definitionNodes())
		if(i instanceof VarDecNode)
		{
			visit((VarDecNode) i);
			list.addAll((List<InsIR>) map.get(i));
		}
		isGlobal = false;
		return list;
	}
	private List<InsIR> getMainIRList()
	{
		List<InsIR> list = new ArrayList<InsIR>();
		visit(ast.mainFunction());
		list.addAll((List<InsIR>) map.get(ast.mainFunction()));
		return list;
	}
	private List<List<InsIR>> getIRList()
	{
		List<List<InsIR>> list = new ArrayList<List<InsIR>>();
		for(ASTNode i: ast.definitionNodes())
		if(i instanceof FunDefNode)
		{
			if(!((FunDefNode) i).name().equals("main"))
			{
				visit((FunDefNode)i);
				list.add((List<InsIR>) map.get(i));
			}
		}else if(i instanceof ClassDefNode)
		{
			visit((ClassDefNode)i);
			List<List<InsIR>> lList = (List<List<InsIR>>)map.get(i);
			for(List<InsIR> j: lList)
			{
				list.add(j);
			}
		}
		return list;
	}
	public List<List<InsIR>> irList()
	{
		if(irList == null)
		{
			irList = new ArrayList<List<InsIR>>();
			globalVarInitList();
			savedRegNumber = regNumber;
			irList.add(mainIrList());
			irList.addAll(getIRList());
		}
		return irList;
	}

	public List<InsIR> mainIrList()
	{
		if(mainIrList == null)
		{
			mainIrList = new LinkedList<>();
			mainIrList.add(new LabelIR("main"));
			//mainIrList.addAll(globalVarInitList());
			mainIrList.addAll(getMainIRList());
		}
		return mainIrList;
	}

	private List<InsIR> globalVarInitList()
	{
		if(globalVarInitList == null)
		{
			globalVarInitList = getGlobalVarList();
		}
		return globalVarInitList;
	}

	public List<StringLitIR> constList()
	{
		return constList;
	}

	public List<GlobalVarIR> globalVars()
	{
		return globalVars;
	}

	private int labelNumber = 0;
	private int regNumber = 16;
	private int blockNumber = 0;
	VarLabelIR getNewLabel(int block)
	{
		return new VarLabelIR("_L" + block + "_" + (labelNumber++));
	}
	VarRegIR getNewReg()
	{
		return new VarRegIR(regNumber++);
	}
	VarLabelIR getStaticString(String val)
	{
		//Add static data...
		//...
		StringLitIR str = new StringLitIR(val);
		constList.add(str);
		return new VarLabelIR(str.getLabel());
	}

	@Override
	public Void visit(BlockNode node)
	{
		Scope lastScope = nowScope;
		nowScope = node.scope();
		super.visit(node);
		List<InsIR> list = new LinkedList<>();
		for(StmtNode i: node.stmts())
		{
			list.addAll((List<InsIR>) map.get(i));
		}
		//list.add(new BinaryIR(BinaryIR.Op.SUB, new VarRegIR(4), new VarIntIR(node.scope().varNumber())));
		map.put(node, list);
		nowScope = lastScope;
		return null;
	}

	@Override
	public Void visit(ExprStmtNode node)
	{
		super.visit(node);
		VarIR var = ((VarIR)map.get(node.expr()));
		if(var == null)
			map.put(node, new LinkedList<>());
		else
			map.put(node, var.irList());
		return null;
	}

	@Override
	public Void visit(IfNode node)
	{
		super.visit(node);
		/*
			[condi]->r0
			CJUMP .L0 (r0 == 0)?
			[if]
		(else existed){
			JUMP .L1
		}
		.L0:
		(else existed){
			[else]
		.L1:
		}
		 */
		int block = blockNumber++;
		VarIR condi = (VarIR) map.get(node.condi());
		List<InsIR>
				ifIR = (List<InsIR>) map.get(node.trueBody()),
				elseIR = null;
		if(node.falseBody()!=null)
			elseIR = (List<InsIR>) map.get(node.falseBody());
		//VarRegIR r0;
		VarLabelIR l0, l1;
		List<InsIR> list = new LinkedList<>();
		l0 = getNewLabel(block);
		l1 = getNewLabel(block);


		//[condi]->r0
		list.addAll(condi.irList());
		//r0 = condi;

		//CJUMP .L0 (r0==0)?
		list.add(new CJumpIR(CJumpIR.LogicOp.EQ, condi, new VarIntIR(0), l0));

		//[if]
		list.addAll(ifIR);


		if(elseIR != null)
		{
		//JUMP .L1
			list.add(new JumpIR(l1));
		}


		//.L0
		list.add(new LabelIR(l0.label()));

		if(elseIR != null)
		{

		//[else]
			list.addAll(elseIR);

		//.L1
			list.add(new LabelIR(l1.label()));
		}


		map.put(node, list);
		return null;
	}

	@Override
	public Void visit(WhileNode node)
	{
		/*
		.L0:
			[condi]->r0
			CJUMP .L1 (r0 == 0)?
			[body]
			JUMP .L0
		.L1:
		 */
		int block = blockNumber++;
		VarLabelIR contiueLabel, exitLabel;
		contiueLabel =  getNewLabel(block);
		exitLabel =  getNewLabel(block);
		node.setLabels(contiueLabel, exitLabel);
		//Debuger.printInfo("labels", node.continueLabel()+" "+node.exitLabel());

		Global.IRBuilder_loopDeepth++;
		super.visit(node);
		Global.IRBuilder_loopDeepth--;

		VarIR condi = (VarIR) map.get(node.condi());
		List<InsIR> body = (List<InsIR>) map.get(node.body());
		//VarRegIR r0;
		VarLabelIR l0, l1;
		List<InsIR> list = new LinkedList<>();
		l0 = contiueLabel;
		l1 = exitLabel;

//		.L0:
		list.add(new LabelIR(l0.label()));
//		[condi]->r0
		list.addAll(condi.irList());
		//r0 = condi;
//		CJUMP .L1 (r0 == 0)?
		list.add(new CJumpIR(CJumpIR.LogicOp.EQ, condi, new VarIntIR(0), l1));

		Global.IRBuilder_loopDeepth++;
//			[body]
		list.addAll(body);
//		JUMP .L0
		list.add(new JumpIR(new VarLabelIR(l0.label())));
		Global.IRBuilder_loopDeepth--;

//		.L1
		list.add(new LabelIR(l1.label()));

		map.put(node, list);
		return null;
	}

	@Override
	public Void visit(ForNode node)
	{
		/*
			[init]
		.L0
			[condi]->r0
			CJUMP .L1 (r0 == 0)?
			[body]
			[step]
			JUMP .L0
		.L1:
		 */
		int block = blockNumber++;
		VarLabelIR contiueLabel, exitLabel;
		contiueLabel =  getNewLabel(block);
		exitLabel =  getNewLabel(block);
		node.setLabels(contiueLabel, exitLabel);

		Global.IRBuilder_loopDeepth++;
		super.visit(node);
		Global.IRBuilder_loopDeepth--;

		VarIR init = (VarIR) map.get(node.init()),
				condi = (VarIR) map.get(node.condi()),
				step = (VarIR) map.get(node.step());
		List<InsIR> body = (List<InsIR>) map.get(node.body());
		//VarIR r0;
		VarLabelIR l0, l1;
		List<InsIR> list = new LinkedList<>();
		l0 = contiueLabel;
		l1 = exitLabel;

//			[init]
		if(init != null)
			list.addAll(init.irList());
//		.L0:
		list.add(new LabelIR(l0.label()));
//			[condi]->r0
		if(condi != null)
		{
			list.addAll(condi.irList());
//		CJUMP .L1 (r0 == 0)?
			list.add(new CJumpIR(CJumpIR.LogicOp.EQ, condi, new VarIntIR(0), l1));
		}else
		{
			//Never Jump to exit
		}

		Global.IRBuilder_loopDeepth++;
//			[body]
		list.addAll(body);
//			[step]
		if(step!=null)
			list.addAll(step.irList());
//      JUMP .L0
		list.add(new JumpIR(new VarLabelIR(l0.label())));
		Global.IRBuilder_loopDeepth--;

//		.L1:
		list.add(new LabelIR(l1.label()));

		map.put(node, list);
		return null;
	}

	@Override
	public Void visit(BreakNode node)
	{
		List<InsIR> list = new LinkedList<>();
		Debuger.printInfo("break",""+node.loop.exitLabel());
		list.add(new JumpIR(node.loop.exitLabel()));
		map.put(node, list);
		return null;
	}

	@Override
	public Void visit(ContinueNode node)
	{
		List<InsIR> list = new LinkedList<>();
		Debuger.printInfo("continue",""+node.loop().continueLabel());
		list.add(new JumpIR(node.loop().continueLabel()));
		map.put(node, list);
		return null;
	}

	@Override
	public Void visit(ReturnNode node)
	{
		super.visit(node);
		List<InsIR> list = new LinkedList<>();
		VarIR ret = (VarIR) map.get(node.ret());
		VarIR r0;
		VarRegIR rax;
		r0 = (VarIR)ret;
		/*
			[ret]->r0
			mov rax r0
			jump exitLabel
		 */
		if(node.ret() != null)
		{
			list.addAll(ret.irList());
			list.add(new MoveIR(new VarRegIR(0), r0));
		}
		list.add(new JumpIR(node.function().exitLabel()));
		map.put(node, list);
		return null;
	}

	@Override
	public Void visit(VarDecNode node)
	{
		super.visit(node);
		List<InsIR> list = new LinkedList<>();
		VarIR r1;
		//Initialize variables
		/*
		(var set r1)
			[init]->r0
			mov r1 r0
		 */
		for(VariableEntity i: node.entity())
		{
			if(isGlobal)
			{
				r1 = new VarMemIR(new VarLabelIR("_#"+i.name()+"#"), new VarIntIR(0));
				globalVars.add(new GlobalVarIR("_#"+i.name()+"#"));
			}
			else
			{
				r1 = getNewReg();
			}
			i.setRegIR(r1);
			if(i.init()!=null){
				VarIR init = (VarIR)map.get(i.init());
				list.addAll(init.irList());
				//r0 = (VarRegIR)init;
				list.add(new MoveIR(r1, init));
			}
		}

		map.put(node, list);
		return null;
	}

	@Override
	public Void visit(FunDefNode node)
	{
		regNumber = savedRegNumber;

		/*
		Params:
			rdi(r7), rsi(r6), rdx(r2), rcx(r1), r8, r9
		 */
		List<InsIR> plist = new LinkedList<>();
		int[] pidx = {7, 6, 2, 1, 8, 9};
		int size = node.entity().params().size();
		boolean isMem = (node.isMember());
		if(isMem)
			size++;
		for(int i=0;i<size;++i)
		if(i==0 && isMem)
		{
			VarRegIR r0;
			r0 = getNewReg();
			thisReg = r0.regIndex();
			plist.add(new MoveIR(new VarRegIR(r0.regIndex()), new VarRegIR(pidx[i])));
		}else
		{
			ParameterEntity pi;
			if(isMem)
				pi = node.entity().params().get(i-1);
			else
				pi = node.entity().params().get(i);
			VarRegIR r0;

			if(i>=6)
			{
				r0 = getNewReg();
				pi.setRegIR(r0);
				plist.add(new LoadIR(new VarRegIR(r0.regIndex()), new VarRegIR(5), new VarIntIR(i-5)));
			}else
			{
//				pi.setRegIR(new VarRegIR(pidx[i]));
				//???
				//this can let regs be re-alloc
				r0 = getNewReg();
				pi.setRegIR(r0);
				plist.add(new MoveIR(new VarRegIR(r0.regIndex()), new VarRegIR(pidx[i])));
			}
		}
		node.setExitLabel(new VarLabelIR("___exit"+node.labelName()));

		super.visit(node);

		List<InsIR> list = new LinkedList<>();
		/*
		Calle-saved:
			rbp(r5), rbx(r3), r12, r13, r14, r15


		(push callee-saved regs)
		(stack poiniter -> rbp)
		...
		(pop callee-saved regs)
		(ret)
		 */
		int[] idx = {5, 3, 12, 13, 14, 15};
		list.add(new LabelIR(node.labelName()));

		//callee-save regs
		list.add(new PushIR(new VarRegIR(5)));
		//move rbp rsp
		list.add(new MoveIR(new VarRegIR(5), new VarRegIR(4)));
		list.add(new BinaryIR(BinaryIR.Op.ADD, new VarRegIR(5), new VarIntIR(8)));
		for(int i=1;i<6;++i)
		{
			list.add(new PushIR(new VarRegIR(idx[i])));
		}
		//skip temp vars
		//Align to 16
		//Enter this function we use call, so rsp = n*16+8
		if((regNumber&1) == 0)
			list.add(new BinaryIR(BinaryIR.Op.SUB, new VarRegIR(4), new VarIntIR(8*(regNumber-16+1))));
		else
			list.add(new BinaryIR(BinaryIR.Op.SUB, new VarRegIR(4), new VarIntIR(8*(regNumber-16+2))));
		//tmp regs
		//list.add(new BinaryIR(BinaryIR.Op.SUB, new VarRegIR(4), new VarIntIR(8*(regNumber-16))));
		//paramters to new regs

		list.addAll(plist);
		//global variables
		if(node.name().equals("main"))
		{
			list.addAll(globalVarInitList);
		}

		//function body
		list.addAll((List<InsIR>) map.get(node.entity().body()));

	//exitLabel:
		list.add(new LabelIR(node.exitLabel().label()));

		//move rsp rbp
		if((regNumber&1) == 0)
			list.add(new BinaryIR(BinaryIR.Op.ADD, new VarRegIR(4), new VarIntIR(8*(regNumber-16+1))));
		else
			list.add(new BinaryIR(BinaryIR.Op.ADD, new VarRegIR(4), new VarIntIR(8*(regNumber-16+2))));
		//list.add(new MoveIR(new VarRegIR(4), new VarRegIR(5)));
		//recover callee-saved regs
		for(int i=5;i>=0;--i)
			list.add(new PopIR(new VarRegIR(idx[i])));
		//return
		list.add(new ReturnIR());

		Global.maxRegNumber = Math.max(Global.maxRegNumber, regNumber);
		Global.regNumber.add(regNumber);
		map.put(node, list);
		return null;
	}

	@Override
	public Void visit(ClassDefNode node)
	{
		List<FunDefNode> funList = node.entity().funList();
		List<List<InsIR>> lList = new ArrayList<List<InsIR>>();
		for(FunDefNode i: funList)
		{
			visit(i);
			lList.add((List<InsIR>) map.get(i));
		}
		FunDefNode cons = node.entity().constructorNode();
		if(cons!=null)
		{
			visit(cons);
			lList.add((List<InsIR>) map.get(cons));
		}

		map.put(node, lList);
		return null;
	}

	@Override
	public Void visit(AssignNode node)
	{
		llMap.add(node.lhs());
		super.visit(node);

		int block = blockNumber++;
		List<InsIR> list = new LinkedList<>();
		VarIR lhs, rhs;
		VarRegIR r0;
		lhs = (VarIR) map.get(node.lhs());
		rhs = (VarIR) map.get(node.rhs());
		list.addAll(lhs.irList());
		list.addAll(rhs.irList());
		list.add(new MoveIR(lhs, rhs));

		map.put(node, rhs.clone(list));
		return null;
	}


	@Override
	public Void visit(BinaryOpNode node)
	{
		super.visit(node);
		int block = blockNumber++;
		BinaryOpNode.BinaryOp op = node.operator();
		VarIR lhs, rhs;
		VarLabelIR l0;
		InsIR tmp;
		List<InsIR> list = new LinkedList<>();
		lhs = (VarIR) map.get(node.left());
		rhs = (VarIR) map.get(node.right());
		if( node.operator() == BinaryOpNode.BinaryOp.LOGIC_AND ||
			node.operator() == BinaryOpNode.BinaryOp.LOGIC_OR)
		{
			VarIR r0, r2;
			VarRegIR r1;
			/*
			<Result: r1>
				[lhs]->r0
				mov r1 0
				CJUMP .L0 (the result is clear?)
				[rhs]->r2
				mov r1 r2
			.L0:
				op r1 r0

			 */
			l0 = getNewLabel(block);
			r0 = lhs;
			r1 = getNewReg();

			list.addAll(r0.irList());
			//???
			//list.add(r1 = 0);
			//list.add(new BinaryIR(BinaryIR.Op.XOR, r1, r1));
			list.add(new MoveIR(r1, new VarIntIR(0)));
			if(op == BinaryOpNode.BinaryOp.LOGIC_AND)
			{
				list.add(new CJumpIR(CJumpIR.LogicOp.EQ, lhs, new VarIntIR(0), l0));

			}else
			{
				list.add(new CJumpIR(CJumpIR.LogicOp.EQ, lhs, new VarIntIR(1), l0));
			}
			list.addAll(rhs.irList());
			r2 = rhs;
			//r1 = r2
			list.add(new MoveIR(r1, r2));

			//.L0:
			list.add(new LabelIR(l0.label()));

			if(op == BinaryOpNode.BinaryOp.LOGIC_AND)
			{
				//r0 = r0 & r1
				tmp = new BinaryIR(BinaryIR.Op.AND, r1, r0);
			}else
			{
				//r0 = r0 | r1
				tmp = new BinaryIR(BinaryIR.Op.OR, r1, r0);
			}
			list.add(tmp);

			map.put(node, new VarRegIR(list, r1.regIndex()));
		}else if (node.left().type() == Options.typeString)
		{
			VarRegIR r0;
			//use funcall
			List<VarIR> plist = new LinkedList();
			r0 = getNewReg();
			if(node.operator() == BinaryOpNode.BinaryOp.EQ ||
					node.operator() == BinaryOpNode.BinaryOp.NE)
			{
				plist.add((VarIR)map.get(node.left()));
				plist.add((VarIR)map.get(node.right()));
				list.addAll(makeCall("__.string__equal", plist));
				list.add(new MoveIR(r0, new VarRegIR(0)));
				if(node.operator() == BinaryOpNode.BinaryOp.NE)
				{
					list.add(new UnaryIR(UnaryIR.Op.NOT, r0));
				}
			}else if(node.operator() == BinaryOpNode.BinaryOp.ADD)
			{
				plist.add((VarIR)map.get(node.left()));
				plist.add((VarIR)map.get(node.right()));
				list.addAll(makeCall("__.string__plus", plist));
				list.add(new MoveIR(r0, new VarRegIR(0)));
			}else
			{
				if(node.operator() == BinaryOpNode.BinaryOp.LT ||
						node.operator() == BinaryOpNode.BinaryOp.LE)
				{
					plist.add((VarIR)map.get(node.left()));
					plist.add((VarIR)map.get(node.right()));
				}else
				{
					plist.add((VarIR)map.get(node.right()));
					plist.add((VarIR)map.get(node.left()));
				}

				switch (node.operator())
				{
					case LT:
					case GT:
						list.addAll(makeCall("__.string__less", plist));break;
					case LE:
					case GE:
						list.addAll(makeCall("__.string__lessEqual", plist));break;
				}
				list.add(new MoveIR(r0, new VarRegIR(0)));
				if(node.operator() == BinaryOpNode.BinaryOp.GT ||
						node.operator() == BinaryOpNode.BinaryOp.GE)
				{
					list.add(new UnaryIR(UnaryIR.Op.NOT, r0));
				}

			}
			map.put(node, new VarRegIR(list, r0.regIndex()));
		}else if (node.operator() == BinaryOpNode.BinaryOp.MUL ||
				node.operator() == BinaryOpNode.BinaryOp.MOD ||
				node.operator() == BinaryOpNode.BinaryOp.DIV)
		{
			VarIR r0, r1;
			VarRegIR r2;
			/*
			<Result: r2>
				[lhs]->r0
				[rhs]->r1
				mov reg0 r0
				triOp (reg0:reg2) r1
				mov r2 reg0/reg2
			 */
			r0 = lhs;
			r1 = rhs;
			r2 = getNewReg();

			list.addAll(lhs.irList());
			list.addAll(rhs.irList());
			list.add(new MoveIR(new VarRegIR(0), r0));
			UnaryIR.Op uOp;
			switch (op)
			{
				case MUL:
					uOp = UnaryIR.Op.MUL;break;
				case MOD:
					uOp = UnaryIR.Op.MOD;break;
				case DIV:
					uOp = UnaryIR.Op.DIV;break;
				default:
					throw new RuntimeException("Unknown operator");
			}
			list.add(new UnaryIR(uOp, r1));
			switch (op)
			{
				case MUL:
				case DIV:
					list.add(new MoveIR(r2, new VarRegIR(0)));break;
				case MOD:
					list.add(new MoveIR(r2, new VarRegIR(2)));break;
				default:

			}
			map.put(node, new VarRegIR(list, r2.regIndex()));

		}else if(op == BinaryOpNode.BinaryOp.LT ||
				op == BinaryOpNode.BinaryOp.GT ||
				op == BinaryOpNode.BinaryOp.LE ||
				op == BinaryOpNode.BinaryOp.GE ||
				op == BinaryOpNode.BinaryOp.GT ||
				op == BinaryOpNode.BinaryOp.EQ ||
				op == BinaryOpNode.BinaryOp.NE)
		{
			/*
			<Result: r2>
				[lhs]->r0
				[rhs]->r1
				op r2 (r0 r1)
			 */

			VarIR r0, r1;
			VarRegIR r2;
			r0 = lhs;
			r1 = rhs;
			r2 = getNewReg();

			list.addAll(lhs.irList());
			list.addAll(rhs.irList());

			TriIR.Op tOp;
			switch (op)
			{
				case LT:
					tOp = TriIR.Op.LT; break;
				case GT:
					tOp = TriIR.Op.GT; break;
				case LE:
					tOp = TriIR.Op.LE; break;
				case GE:
					tOp = TriIR.Op.GE; break;
				case EQ:
					tOp = TriIR.Op.EQ; break;
				case NE:
					tOp = TriIR.Op.NE; break;
				default:
					throw new RuntimeException("Op not find.");
			}
			list.add(new TriIR(tOp, r0, r1));
			list.add(new MoveIR(r2, new VarRegIR(0), true));
			map.put(node, new VarRegIR(list, r2.regIndex()));
		}else
		{
			/*
			<Result: r2>
				[lhs]->r0
				[rhs]->r1
				mov r2 r0
				op r2 r1
			 */

			VarIR r0, r1;
			VarRegIR r2;
			r0 = lhs;
			r1 = rhs;
			r2 = getNewReg();

			list.addAll(lhs.irList());
			list.addAll(rhs.irList());
			BinaryIR.Op bOp;
			switch (op)
			{
				case ADD:
					bOp = BinaryIR.Op.ADD; break;
				case SUB:
					bOp = BinaryIR.Op.SUB; break;
				case LSHIFT:
					bOp = BinaryIR.Op.LSHIFT; break;
				case RSHIFT:
					bOp = BinaryIR.Op.RSHIFT; break;
				case BIT_AND:
				case LOGIC_AND:
					bOp = BinaryIR.Op.AND; break;
				case BIT_XOR:
					bOp = BinaryIR.Op.XOR; break;
				case BIT_OR:
				case LOGIC_OR:
					bOp = BinaryIR.Op.OR; break;
				default:
					Debuger.printInfo("Operator",op.toString());
					throw new RuntimeException("Op not find.");
			}
			if(op == BinaryOpNode.BinaryOp.LSHIFT ||
					op == BinaryOpNode.BinaryOp.RSHIFT)
			{
				list.add(new MoveIR(r2, r0));
				if(!(rhs instanceof VarIntIR))
				{
					list.add(new MoveIR(new VarRegIR(1), rhs));
					list.add(new BinaryIR(bOp, r2, new VarRegIR(1)));
				}else
					list.add(new BinaryIR(bOp, r2, rhs));

				map.put(node, r2.clone(list));
			}else
			{
				list.add(new MoveIR(r2, r0));
				list.add(new BinaryIR(bOp, r2, r1));
				map.put(node, r2.clone(list));
			}
		}
		return null;
	}

	//string + string
	// && static data && global var
	@Override
	public Void visit(CreatorNode node)
	{
		super.visit(node);
		List<VarIR> plist = new LinkedList<>();
		List<InsIR> list = new LinkedList<>();
		VarRegIR r0, r1;
		if(node.type() instanceof TypeArray)
		{
			Type rootType = ((TypeArray) node.type()).rootType();
			r0 = getNewReg();
			//Array
			plist.add(new VarIntIR(node.args().size()));
			list.addAll(makeCall("__.array_.array",plist));

			//fill the *aSize
			list.add(new MoveIR(r0, new VarRegIR(0)));

			for(int i=0;i<node.args().size();++i)
			{
				VarIR arg = (VarIR) map.get(node.args().get(i));
				list.addAll(arg.irList());
				list.add(new StoreIR(r0, new VarIntIR(i), arg));
			}

			plist = new LinkedList<>();
			//int *aSize
			plist.add(new VarRegIR(r0.regIndex()));
			//int dim
			plist.add(new VarIntIR(node.args().size()));
			if(node.args().size() < node.dim())
			{
				//int eSize
				plist.add(new VarIntIR(8));
				//FUNC func
				plist.add(new VarIntIR(0));
			}else
			{
				//int eSize
				plist.add(new VarIntIR(rootType.size()));

				//FUNC func
				//constuctor?
				if(rootType instanceof TypeClass)
					plist.add(new VarIntIR(0));
				else
					plist.add(new VarIntIR(0));
			}


			//void* __array_new(int *aSize, int dim, int eSize, FUNC func)
			list.addAll(makeCall("__.array_new", plist));

			r1 = getNewReg();
			list.add(new MoveIR(r1, new VarRegIR(0)));
			map.put(node, r1.clone(list));
		}else
		{
			r0 = getNewReg();
			//class
			plist.add(new VarIntIR(node.type().size()));
			list.addAll(makeCall("malloc", plist));

			list.add(new MoveIR(r0, new VarRegIR(0)));
			if(node.type() instanceof TypeClass && ((TypeClass) node.type()).refEntity().constructorNode()!=null)
			{
				plist.set(0, new VarRegIR(r0.regIndex()));
				list.addAll(makeCall("__"+node.type()+"_"+node.type(), plist));
			}

			map.put(node, r0.clone(list));
		}

		return null;
	}

	@Override
	public Void visit(PrefixOpNode node)
	{
		if(node.operator() == UnaryOpNode.UnaryOp.PRE_DEC ||
				node.operator() == UnaryOpNode.UnaryOp.PRE_INC)
		{
			llMap.add(node.expr());
		}
		super.visit(node);
		List<InsIR> list = new LinkedList<>();
		VarIR lhs = (VarIR) map.get(node.expr());
		VarIR r0;
		VarRegIR r1;

		r0 = (VarIR)lhs;
		list.addAll(lhs.irList());
		if(node.operator()!=UnaryOpNode.UnaryOp.PRE_INC && node.operator()!=UnaryOpNode.UnaryOp.PRE_DEC)
		{
			r1 = getNewReg();
			list.add(new MoveIR(r1, r0));
		}else
			r1 = null;
		switch (node.operator())
		{
			//++a
			/*
			<Result: r0>
				[a]->r0
				r0++
			 */
			case PRE_DEC:
				list.add(new BinaryIR(BinaryIR.Op.SUB, r0, new VarIntIR(1)));
				break;
			case PRE_INC:
				list.add(new BinaryIR(BinaryIR.Op.ADD, r0, new VarIntIR(1)));
				break;
			case ADD:
				break;
			case MINUS:
				list.add(new UnaryIR(UnaryIR.Op.NEG, r1));
				break;
			case BIT_NOT:
				list.add(new UnaryIR(UnaryIR.Op.NOT, r1));
				break;
			case LOGIC_NOT:
				list.add(new BinaryIR(BinaryIR.Op.XOR, r1, new VarIntIR(1)));
				break;
			default:
				throw new RuntimeException("Unknown type.");
		}
		if(node.operator()!=UnaryOpNode.UnaryOp.PRE_INC && node.operator()!=UnaryOpNode.UnaryOp.PRE_DEC)
		{
			map.put(node, r1.clone(list));
		}else
		{
			map.put(node, r0.clone(list));
		}

		return null;
	}

	@Override
	public Void visit(SuffixOpNode node)
	{
		//a++
		/*
		<Result: r1>
			[a]->r0
			mov r1 r0
			add r0 1
		 */
		if(node.operator() == UnaryOpNode.UnaryOp.SUF_INC||
				node.operator() == UnaryOpNode.UnaryOp.SUF_DEC)
		{
			llMap.add(node.expr());
		}
		super.visit(node);
		List<InsIR> list = new LinkedList<>();
		VarIR ref = (VarIR) map.get(node.expr());
		VarIR r0;
		VarRegIR r1;
		//r0 maybe VarMemIR
		r0 = (VarIR)ref;
		r1 = getNewReg();
		list.addAll(ref.irList());
		list.add(new MoveIR(r1, r0));
		switch (node.operator())
		{
			case SUF_DEC:
				list.add(new BinaryIR(BinaryIR.Op.SUB, r0, new VarIntIR(1)));
				break;
			case SUF_INC:
				list.add(new BinaryIR(BinaryIR.Op.ADD, r0, new VarIntIR(1)));
				break;
		}
		map.put(node, r1.clone(list));
		return null;
	}

	@Override
	public Void visit(ArefNode node)
	{
		/*
		<Result: r2>
			[ref]->r0
			[index]->r1
			load r2 [r0+r1*8]
		 */

		super.visit(node);
		List<InsIR> list = new LinkedList<>();
		VarIR ref = (VarIR) map.get(node.ref()),
			index = (VarIR) map.get(node.index());
		VarIR r0, r1;
		VarRegIR r2;
		r0 = ref;
		r1 = index;


		list.addAll(ref.irList());
		list.addAll(index.irList());
		if(!llMap.contains(node))
		{
			r2 = getNewReg();
			list.add(new LoadIR(r2, r0, r1));
			map.put(node, new VarRegIR(list, r2.regIndex()));
		}else
		{
			map.put(node, new VarMemIR(list, r0, r1));
		}




		return null;
	}

	private List<InsIR> makeCall(String funName, List<VarIR> params)
	{
		/*
		Params:
			rdi(r7), rsi(r6), rdx(r2), rcx(r1), r8, r9
		Calle-saved:
			rbp(r5), rbx(r3), r12, r13, r14, r15
		The stack pointer: (aligned to a 16-byte)
			rsp(r4)
		the return address is at [rsp], the first memory parameter is at [rsp+8]

		Code:
			push [params]
			mov i [params]
			call label
		 */
		List<InsIR> list = new LinkedList<>();
		VarIR r0;
		int []idx = {7, 6, 2, 1, 8, 9};

		//Set params
		for(int i=params.size()-1;i>=6; --i)
		{
			r0 = params.get(i);
			list.addAll(r0.irList());
		}
		for(int i=0; i<params.size()&&i<6; ++i)
		if(i<6)
		{
			r0 = params.get(i);
			list.addAll(r0.irList());
		}
		list.add(new SpecialIR(SpecialIR.Type.CALLER_SAVE));
		for(int i=params.size()-1;i>=6; --i)
		{
			r0 = params.get(i);
			list.add(new PushIR(r0));
		}
		for(int i=0; i<params.size()&&i<6; ++i)
			if(i<6)
			{
				r0 = params.get(i);
				list.add(new MoveIR(new VarRegIR(idx[i]), r0));
			}
		//Call
		list.add(new CallIR(funName, params.size()));

		//pop all params
		if(params.size() > 6)
			list.add(new BinaryIR(BinaryIR.Op.ADD, new VarRegIR(4), new VarIntIR((params.size()-6)*8)));
		list.add(new SpecialIR(SpecialIR.Type.CALLER_RECOVER));
		/*
		for(int i=Math.min(5, params.size()-1); i>=0; --i)
		{
			list.add(new PopIR(new VarRegIR(idx[i])));
		}*/
		return list;
	}
	@Override
	public Void visit(FuncallNode node)
	{
		super.visit(node);
		List<InsIR> list = new LinkedList<>();
		List<VarIR> plist = new LinkedList<>();
		VarIR preVar = (VarIR) map.get(node.function());
		VarRegIR r0;
		String funName;
		/*
		(member)
			[this, param]
		(variable)

		 */

		if(node.function() instanceof MemberNode)
			plist.add(preVar);
		else if(((FunctionEntity)(((VariableNode)node.function()).refEntity())).belongsTo() !=null)
		{
			plist.add(new VarRegIR(thisReg));
		}
		for(int i=0;i<node.params().size(); ++i)
		{
			VarIR tmp;
			plist.add(tmp = (VarIR) map.get(node.params().get(i)));
		}
		funName = ((VariableNode) node.function()).funName();
		//Debuger.printInfo("funName",funName);
		list.addAll(makeCall(funName, plist));
		r0 = getNewReg();
		list.add(new MoveIR(r0, new VarRegIR(0)));
		map.put(node, new VarRegIR(list, r0.regIndex()));

		return null;
	}


	void visitSimpleVar(VariableNode node)
	{
		List<InsIR> list = new LinkedList<>();
		VarIR r0, r1, r2;
		if(!(node.type() instanceof TypeFunction))
		{
			if(node.name().equals("null"))
			{
				map.put(node, new VarIntIR(new LinkedList<>(), 0));
			}else if(node.name().equals("this"))
			{
				map.put(node, new VarRegIR(new LinkedList<>(), thisReg));
			}else{
				/*
				<Result: r0>
					load r0 [???]
				 */
				//((LinkedList<InsIR>) list).push();
				r0 = ((ParameterEntity)node.refEntity()).regIR();
				map.put(node, r0.clone(list));
			}

		}else
		{
		/*
			nothing to do
		 */
			map.put(node, new VarRegIR(list, -1));

		}
	}
	private void visitMemberVar(VariableNode node)
	{
		List<InsIR> list = new LinkedList<>();
		VarIR parent = new VarRegIR(thisReg);
		VarIR r0;
		VarRegIR r1;

		r0 = parent;
		if(!(node.type() instanceof TypeFunction))
		{
		/*
		<Result: r1>
			[parent]->r0
			load r1 [r0+indexOfMember*8]
		 */
			VarIntIR indexOfMember = new VarIntIR(((ParameterEntity)node.refEntity()).rank());
			if(!llMap.contains(node))
			{
				r1 = getNewReg();
				list.add(new LoadIR(r1 ,r0, indexOfMember));
				map.put(node, new VarRegIR(list, r1.regIndex()));
			}else
			{
				map.put(node, new VarMemIR(list, r0, indexOfMember));
			}


		}else
		{
		/*
		<Result: r0>
			[parent]->r0
		 */
			map.put(node, r0.clone(list));
		}
	}
	@Override
	public Void visit(VariableNode node)
	{
		super.visit(node);
		List<InsIR> list = new LinkedList<>();
		VarRegIR r0, r1, r2;

		if(node.refEntity() instanceof ParameterEntity &&
				((ParameterEntity)node.refEntity()).isMember())
		{
			visitMemberVar(node);
		}else
		{
			visitSimpleVar(node);
		}
		return null;
	}

	@Override
	public Void visit(MemberNode node)
	{
		super.visit(node);
		List<InsIR> list = new LinkedList<>();
		VarIR parent = (VarIR) map.get(node.parent());
		VarRegIR r1, r2;

		list.addAll(parent.irList());
		if(!(node.type() instanceof TypeFunction))
		{
			VarRegIR r0 = (VarRegIR)parent;
		/*
		<Result: r1>
			[parent]->r0
			load r1 [r0+indexOfMember*8]
		 */

			VarIntIR indexOfMember = new VarIntIR(((ParameterEntity)node.refEntity()).rank());
			if(!llMap.contains(node))
			{
				r1 = getNewReg();
				list.add(new LoadIR(r1 ,r0, indexOfMember));
				map.put(node, new VarRegIR(list, r1.regIndex()));
			}else
				map.put(node, new VarMemIR(list, r0, indexOfMember));
		}else
		{
			VarIR r0 = (VarIR)parent;
		/*
		<Result: r0>
			[parent]->r0
		 */
			map.put(node, r0.clone(list));
		}
		return null;
	}
	@Override
	public Void visit(IntLiteralNode node)
	{
		map.put(node, new VarIntIR(node.val()));
		return null;
	}

	@Override
	public Void visit(StringLiteralNode node)
	{
		//Require Static Memory Space
		//!!!
		//VarLabelIR
		map.put(node, getStaticString(node.val()));
		return null;
	}

	@Override
	public Void visit(BoolLiteralNode node)
	{
		if(node.val())
			map.put(node, new VarIntIR(1));
		else
			map.put(node, new VarIntIR(0));
		return null;
	}
}
