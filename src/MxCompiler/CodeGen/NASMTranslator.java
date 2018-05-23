/*
	Coded by timemachine on 18-5-23
	MxCompiler.CodeGen.NASMTranslator
*/


package MxCompiler.CodeGen;

import MxCompiler.IR.*;

import java.util.*;

public class NASMTranslator implements IRVisitor
{
	private List<InsIR> insIRList;
	private List<StringLitIR> litIRlist;
	private List<String> codeStr;
	static final String CODE_PREFIX = "\t";
	private Map<InsIR, List<String>> map = new HashMap<>();

	public NASMTranslator(List<InsIR> insIRList, List<StringLitIR> litIRlist)
	{
		this.insIRList = insIRList;
		this.litIRlist = litIRlist;
		this.codeStr = null;
	}

	private List<String> getCodeStr()
	{
		List<String> list = new LinkedList<>();

		//Prefix
		list.add("default rel");
		list.add("default main");

		list.add("SECTION .text");
		//visit(InsIR)
		list.addAll(visitInsIR(insIRList));

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

	private List<String> visitInsIR(List<InsIR> list)
	{
		List<String> ret = new LinkedList<>();
		for(InsIR i: list)
		{
			i.accept(this);
			ret.addAll((List<String>)map.get(i));
		}
		return ret;
	}
	private List<String> visitLitIR(List<StringLitIR> list)
	{
		List<String> ret = new LinkedList<>();
		for(StringLitIR i: list)
		{
			ret.add(i.getLabel()+":");
			ret.add(CODE_PREFIX+i.toCodeStr());
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
		String op;
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
		list.add(CODE_PREFIX + "set"+op+"\t"+node.dest());
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
			case MUL: op="mul"; break;
			case DIV: op="div"; break;
			case MOD: op="div"; break;
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
		list.add(CODE_PREFIX + "j"+"\t"+node.aim().label());
		map.put(node, list);
	}

	@Override
	public void visit(CallIR node)
	{
		List<String> list = new LinkedList<>();
		list.add(CODE_PREFIX + "j"+"\t"+node.label());
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
		list.add(CODE_PREFIX+"mov\t"+node.dest()+node.src());
		map.put(node, list);
	}

	@Override
	public void visit(StoreIR node)
	{
		List<String> list = new LinkedList<>();
		list.add(CODE_PREFIX+"mov\t"+node.dest()+node.src());
		map.put(node, list);
	}

	@Override
	public void visit(MoveIR node)
	{
		List<String> list = new LinkedList<>();
		list.add(CODE_PREFIX+"mov\t"+node.lhs()+node.rhs());
		map.put(node, list);
	}
}