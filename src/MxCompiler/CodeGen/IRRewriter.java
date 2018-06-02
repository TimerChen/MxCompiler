/*
	Coded by timemachine on 18-5-26
	MxCompiler.CodeGen.IRRewriter
*/


package MxCompiler.CodeGen;

import MxCompiler.IR.*;
import MxCompiler.tools.Debuger;

import java.util.*;

public class IRRewriter implements IRVisitor
{
	//use 13, 14, 15
	static final private VarRegIR []reg=
			{new VarRegIR(13), new VarRegIR(14), new VarRegIR(15)};
	private List<List<Integer>> colors;
	private List<BasicBlock> blkLists;

	private List<Integer> nowColor;

	private List<InsIR> newIRList;

	public IRRewriter(List<List<Integer>> colors, List<BasicBlock> irs)
	{
		this.colors = colors;
		this.blkLists = irs;
	}
	public void rewrite()
	{
		for(int i=0; i<blkLists.size(); ++i)
		{
			BasicBlock now = blkLists.get(i);

			nowColor = colors.get(i);
			while(now != null)
			{
				newIRList = new ArrayList<InsIR>();
				List<InsIR> irList = now.irList();
				int n = irList.size();
				for(int j=0; j<n; ++j)
				{
					InsIR ir = irList.get(j);
					ir.accept(this);
				}
				now.setIrList(newIRList);
				now = now.next();
			}

		}
	}

	VarIR   colorDIR(VarIR oVar, VarRegIR r0, VarRegIR r1)
	{
		return colorIR(oVar, r0, r1, false, false);
	}
	VarIR colorS0IR(VarIR oVar, VarRegIR r0, VarRegIR r1)
	{
		return colorIR(oVar, r0, r1, true, false);
	}
	VarIR colorSIR(VarIR oVar, VarRegIR r0, VarRegIR r1)
	{
		return colorIR(oVar, r0, r1, true, true);
	}
	VarIR colorIR(VarIR oVar, VarRegIR r0, VarRegIR r1, boolean isSrc, boolean canInt)
	{
		if(oVar instanceof VarRegIR)
		{
			VarRegIR var = (VarRegIR)oVar;
			int i = var.regIndex();
			if(nowColor.get(i) == -1)
			{
				i = i-16;
				if(isSrc)
				{
					VarMemIR mem = new VarMemIR(new VarRegIR(5), new VarIntIR(-i-1-6));
					newIRList.add(new MoveIR(r0, mem));
					return r0;
				}else
				{
					VarMemIR mem = new VarMemIR(new VarRegIR(5), new VarIntIR(-i-1-6));
					//newIRList.add(new MoveIR(mem, r0));
					return mem;
				}
			}else
			{
				return new VarRegIR(nowColor.get(i));
			}
		}else if(oVar instanceof VarIntIR || oVar instanceof VarLabelIR)
		{
			//VarIntIR var = (VarIntIR)oVar;
			if(!isSrc)
				throw new RuntimeException("dest is imm");
			if(!canInt)
			{
				newIRList.add(new MoveIR(r0, oVar));
				return r0;
			}else
				return oVar;

		}else if(oVar instanceof VarMemIR)
		{
			VarMemIR var = (VarMemIR)oVar;
			VarIR tmp0, tmp1;
			if(isSrc)
			{
				if(var.base() instanceof VarLabelIR)
				{
					newIRList.add(new MoveIR(r0, var));
					return r0;
				}else
				if(var.index() instanceof VarIntIR)
				{
					tmp0 = colorIR(var.base(), r0, null, true, false);
					newIRList.add(new MoveIR(r0, new VarMemIR(tmp0, var.index())));
					return r0;
				}else
				{
					tmp0 = colorIR(var.base(), r0, null, true, false);
					tmp1 = colorIR(var.index(), r1, null, true, false);
					newIRList.add(new MoveIR(r0, new VarMemIR(tmp0, tmp1)));
					return r0;
				}
			}else
			{
				if(var.base() instanceof VarLabelIR)
				{
					return var;
				}else
				if(var.index() instanceof VarIntIR)
				{
					tmp0 = colorIR(var.base(), r0, null, true, false);
					tmp1 = var.index();
				}else
				{
					tmp0 = colorIR(var.base(), r0, null, true, false);
					tmp1 = colorIR(var.index(), r1, null, true, false);
				}
				return new VarMemIR(tmp0, tmp1);
			}

		}else
			return oVar;
	}
	@Override
	public void visit(AlignIR node)
	{
		//Nothing
		newIRList.add(node);
	}

	@Override
	public void visit(TriIR node)
	{
		//o<=[a,b]
		node.setSrc0(colorS0IR(node.src0(), reg[0], reg[1]));
		node.setSrc1(colorSIR(node.src1(), reg[1], reg[2]));
		newIRList.add(node);
	}

	@Override
	public void visit(BinaryIR node)
	{
		//o<=o+o

		node.setRhs(colorSIR(node.rhs(), reg[0], reg[1]));
		//node.setLhs(colorS0IR(node.lhs(), reg[0], reg[1]));
		VarIR oVar = (VarIR)node.lhs();
		if(oVar instanceof VarRegIR)
		{
			//lhs cannot be a varmemir
			VarRegIR var = (VarRegIR)oVar;
			int i = var.regIndex();
			if(nowColor.get(i) == -1)
			{
				i = i-16;
				VarMemIR mem = new VarMemIR(new VarRegIR(5), new VarIntIR(-i-1-6));
				newIRList.add(new MoveIR(reg[1], mem));
				node.setLhs(reg[1]);
				newIRList.add(node);
				newIRList.add(new MoveIR(mem, reg[1]));
			}else
			{
				newIRList.add(node);
				node.setLhs(new VarRegIR(nowColor.get(i)));
			}
		}else
		{
			VarMemIR var = (VarMemIR)oVar;
			node.setLhs(colorDIR(node.lhs(), reg[1], reg[2]));
			newIRList.add(node);
		}

	}

	@Override
	public void visit(UnaryIR node)
	{
		if(node.has2Dest())
		{
			//mul mod div
			//o<=o
			/*
			VarRegIR var = (VarRegIR)node.src();
			int i = var.regIndex();
			if(nowColor.get(i) == -1)
			{
				i = i-16;
				VarMemIR mem = new VarMemIR(new VarRegIR(5), new VarIntIR(-i-1-6));
				newIRList.add(new MoveIR(reg[0], mem));
				node.setSrc(reg[0]);
				newIRList.add(node);
				newIRList.add(new MoveIR(mem, reg[0]));
			}else
			{
				newIRList.add(node);
			}
			*/

			node.setSrc(colorS0IR(node.src(), reg[0], reg[1]));
			newIRList.add(node);

		}else
		{
			//neg not
			//?<=o
			//node.setSrc(colorS0IR(node.src(),reg[0], reg[1]));
			VarIR oVar= (VarIR)node.src();
			if(oVar instanceof VarMemIR)
			{
				node.setSrc(colorDIR(node.src(), reg[0], reg[1]));
				newIRList.add(node);
			}else if(oVar instanceof VarRegIR)
			{
				VarRegIR var = (VarRegIR)oVar;
				int i = var.regIndex();
				if(nowColor.get(i) == -1)
				{
					i = i-16;
					VarMemIR mem = new VarMemIR(new VarRegIR(5), new VarIntIR(-i-1-6));
					newIRList.add(new MoveIR(reg[0], mem));
					node.setSrc(reg[0]);
					newIRList.add(node);
					newIRList.add(new MoveIR(mem, reg[0]));
				}else
				{
					newIRList.add(node);
					node.setSrc(new VarRegIR(nowColor.get(i)));
				}
			}else
				throw new RuntimeException("Unknown var type");


		}

	}

	@Override
	public void visit(CJumpIR node)
	{
		node.setLhs(colorS0IR(node.lhs(), reg[0], reg[1]));
		node.setRhs(colorSIR(node.rhs(), reg[1], reg[2]));
		newIRList.add(node);
	}

	@Override
	public void visit(JumpIR node)
	{
		//Nothing
		newIRList.add(node);
	}

	@Override
	public void visit(CallIR node)
	{
		//Nothing
		newIRList.add(node);
	}

	@Override
	public void visit(LabelIR node)
	{
		//Nothing
		newIRList.add(node);
	}

	@Override
	public void visit(ReturnIR node)
	{
		//Nothing
		newIRList.add(node);
	}

	@Override
	public void visit(PushIR node)
	{
		node.setSrc(colorS0IR(node.src(),reg[0], reg[1]));
		newIRList.add(node);
	}

	@Override
	public void visit(PopIR node)
	{
		node.setDest(node.dest());
		newIRList.add(node);
	}

	@Override
	public void visit(LoadIR node)
	{
		/*
		o<=[o,o]
			a<=[]
			b<=[]
			a<=[a,b]
			[]<=a
		*/
		node.setSrc(colorSIR(node.src(), reg[0], reg[1]));
		newIRList.add(node);
		node.setDest(colorDIR(node.dest(), reg[0], reg[1]));
	}

	@Override
	public void visit(StoreIR node)
	{
		/*
		[o,o]<=o
			a<=[]
			b<=[]
			c<=[]
			[a,b] <= c
			mov [a,b] c
		 */
		node.setSrc(colorSIR(node.src(), reg[2], reg[0]));
		node.setDest(colorDIR(node.dest(), reg[0], reg[1]));
		newIRList.add(node);
	}

	@Override
	public void visit(MoveIR node)
	{
		if(node.isZX())
		{
			//[o,o]<=o
			//o<=o
			if(node.lhs() instanceof VarMemIR)
			{
				node.setLhs(colorDIR(node.lhs(), reg[0], reg[1]));
				newIRList.add(node);
				newIRList.add(new MoveIR(node.lhs(), reg[2]));
				node.setLhs(reg[2]);
			}else
			{
				newIRList.add(node);
				node.setLhs(colorDIR(node.lhs(), reg[0], reg[1]));
				newIRList.add(new MoveIR(node.lhs(), reg[2]));
				node.setLhs(reg[2]);
			}
		}else
		{
			//[o,o]<=o
			//o<=[o,o]
			//o<=o
			if(node.lhs() instanceof VarMemIR)
			{
				node.setRhs(colorSIR(node.rhs(), reg[2], reg[0]));
				node.setLhs(colorDIR(node.lhs(), reg[0], reg[1]));
				newIRList.add(node);
			}else if(node.rhs() instanceof VarMemIR)
			{
				node.setRhs(colorSIR(node.rhs(), reg[0], reg[1]));
				newIRList.add(node);
				node.setLhs(colorDIR(node.lhs(), reg[0], reg[1]));
			}else
			{
				node.setRhs(colorSIR(node.rhs(), reg[0], reg[1]));
				newIRList.add(node);
				node.setLhs(colorDIR(node.lhs(), reg[1], reg[2]));
			}
		}




	}

	@Override
	public void visit(SpecialIR node)
	{
		int []idx = {7,6,2,1,8,9};
		switch (node.type())
		{
			case CALLER_SAVE:
				for(int i=0;i<6;++i)
					newIRList.add(new PushIR(new VarRegIR(idx[i])));
				break;
			case CALLER_RECOVER:
				for(int i=5;i>=0;--i)
					newIRList.add(new PopIR(new VarRegIR(idx[i])));
				break;
			default:
		}
	}
}
