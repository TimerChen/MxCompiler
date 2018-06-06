/*
	Coded by timemachine on 18-5-23
	MxCompiler.CodeGen.NASMTranslator
*/


package MxCompiler.CodeGen;

import MxCompiler.IR.*;
import MxCompiler.tools.Debuger;

import java.util.*;

public class NASMTranslator implements IRVisitor
{
	private List<InsIR> insIRList;
	private List<StringLitIR> litIRlist;
	private List<String> codeStr;
	private List<GlobalVarIR> globalVarIRS;
	static final String CODE_PREFIX = "\t";
	private Map<InsIR, List<String>> map = new HashMap<>();

	public NASMTranslator(List<InsIR> insIRList, List<StringLitIR> litIRlist, List<GlobalVarIR>globalVarIRS)
	{
		this.insIRList = insIRList;
		this.litIRlist = litIRlist;
		this.globalVarIRS = globalVarIRS;
		this.codeStr = null;
	}

	private List<String> getCodeStr()
	{
		List<String> list = new LinkedList<>();

		//Prefix
		list.add("default rel");
		list.add("global main");

		list.add("SECTION .text");
		//visit(InsIR)
		list.addAll(visitInsIR(insIRList));

		list.add("SECTION .bss");
		list.addAll(visitGlobalVarIR(globalVarIRS));

		list.add("SECTION .rodata");
		//visit(StringLitIR)
		list.addAll(visitLitIR(litIRlist));
		return list;
	}
	public List<String> codeStr()
	{
		if(codeStr == null)
		{
			codeStr = getCodeStr();
		}
		return codeStr;
	}
	private List<String> visitGlobalVarIR(List<GlobalVarIR> list)
	{
		List<String> ret = new LinkedList<>();
		for(GlobalVarIR i: list)
		{
			ret.add(i.toCodeStr());
		}
		return ret;
	}
	private List<String> visitInsIR(List<InsIR> list)
	{
		List<String> ret = new LinkedList<>();
		for(InsIR i: list)
		{
			if(!i.useless)
			{
				i.accept(this);
				ret.addAll((List<String>) map.get(i));
			}
		}
		return ret;
	}
	private List<String> visitLitIR(List<StringLitIR> list)
	{
		List<String> ret = new LinkedList<>();
		for(StringLitIR i: list)
		{
			ret.add(i.toCodeStr(i.getLabel()));
		}
		return ret;
	}

	@Override
	public void visit(AlignIR node)
	{
		//needless now
	}


	@Override
	public void visit(TriIR node)
	{
		List<String> list = new LinkedList<>();
		list.add(CODE_PREFIX + "cmp\t"+node.src0()+",\t"+node.src1());
		String op, rop;
		switch (node.operator())
		{
			case LT: op="l";rop="ge"; break;
			case GT: op="g";rop="le"; break;
			case LE: op="le";rop="g"; break;
			case GE: op="ge";rop="l"; break;
			case EQ: op="e";rop="ne"; break;
			case NE: op="ne";rop="e"; break;
			default:throw new RuntimeException("Op not find");
		}
		list.add(CODE_PREFIX + "set"+op+"\t"+node.dest().toCodeStr1());
		//list.add(CODE_PREFIX + "cmov"+op+"\t"+node.dest().toCodeStr1()+",\t"+"1");
		map.put(node, list);
	}

	@Override
	public void visit(BinaryIR node)
	{
		List<String> list = new LinkedList<>();
		String op;
		switch (node.operator())
		{
			case ADD: op="add"; break;
			case SUB: op="sub"; break;
			case LSHIFT: op="shl"; break;
			case RSHIFT: op="shr"; break;
			case AND: op="and"; break;
			case XOR: op="xor"; break;
			case OR: op="or"; break;
			default:throw new RuntimeException("Op not find");
		}
		if(node.operator() == BinaryIR.Op.LSHIFT ||
				node.operator() == BinaryIR.Op.RSHIFT)

		{
			if(node.rhs() instanceof VarIntIR)
				list.add(CODE_PREFIX+ op + "\t" + node.lhs() + ",\t" + node.rhs());
			else
				list.add(CODE_PREFIX+ op + "\t" + node.lhs() + ",\tcl");
		}else
			list.add(CODE_PREFIX+ op + "\t" + node.lhs() + ",\t" + node.rhs());
		map.put(node, list);
	}

	@Override
	public void visit(UnaryIR node)
	{

		List<String> list = new LinkedList<>();
		String op;
		switch (node.operator())
		{
			case MUL: op="imul"; break;
			case DIV:
			case MOD:
				op="idiv";
				list.add(CODE_PREFIX + "cqo");
				break;
			case NEG: op="neg"; break;
			case NOT: op="not"; break;
			default:throw new RuntimeException("Op not find");
		}
		list.add(CODE_PREFIX+ op + "\t" + node.src());
		map.put(node, list);
	}

	@Override
	public void visit(CJumpIR node)
	{

		List<String> list = new LinkedList<>();
		String op;
		list.add(CODE_PREFIX + "cmp\t"+node.lhs()+",\t"+node.rhs());
		switch (node.operator())
		{
			case LT: op="l"; break;
			case GT: op="g"; break;
			case LE: op="le"; break;
			case GE: op="ge"; break;
			case EQ: op="e"; break;
			case NE: op="ne"; break;
			default:throw new RuntimeException("Op not find");
		}
		list.add(CODE_PREFIX + "j"+op+"\t"+node.aim().label());
		map.put(node, list);
	}

	@Override
	public void visit(JumpIR node)
	{
		List<String> list = new LinkedList<>();
		list.add(CODE_PREFIX + "jmp"+"\t"+node.aim().label());
		map.put(node, list);
	}

	@Override
	public void visit(CallIR node)
	{
		List<String> list = new LinkedList<>();
		list.add(CODE_PREFIX + "call"+"\t"+node.label());
		map.put(node, list);
	}

	@Override
	public void visit(LabelIR node)
	{
		List<String> list = new LinkedList<>();
		list.add(node.label()+":");
		map.put(node, list);
	}

	@Override
	public void visit(ReturnIR node)
	{
		List<String> list = new LinkedList<>();
		list.add(CODE_PREFIX+"ret");
		map.put(node, list);
	}

	@Override
	public void visit(PushIR node)
	{

		List<String> list = new LinkedList<>();
		list.add(CODE_PREFIX+"push\t"+node.src());
		map.put(node, list);
	}

	@Override
	public void visit(PopIR node)
	{

		List<String> list = new LinkedList<>();
		list.add(CODE_PREFIX+"pop\t"+node.dest());
		map.put(node, list);
	}

	@Override
	public void visit(LoadIR node)
	{
		List<String> list = new LinkedList<>();
		list.add(CODE_PREFIX+"mov\t"+node.dest()+",\t"+node.src());
		map.put(node, list);
	}

	@Override
	public void visit(StoreIR node)
	{
		List<String> list = new LinkedList<>();
		list.add(CODE_PREFIX+"mov\t"+node.dest()+",\t"+node.src());
		map.put(node, list);
	}

	@Override
	public void visit(MoveIR node)
	{
		List<String> list = new LinkedList<>();
		if(node.isZX())
			list.add(CODE_PREFIX+"movzx\t"+node.lhs()+",\t"+node.rhs().toCodeStr1());
		else
			list.add(CODE_PREFIX+"mov\t"+node.lhs()+",\t"+node.rhs());
		map.put(node, list);
	}

	@Override
	public void visit(SpecialIR node)
	{
		throw new RuntimeException("SpecialIR unexpected.");
	}
}
