/*
	Coded by timemachine on 18-5-23
	MxCompiler.IR.IRVisitor
*/


package MxCompiler.IR;

public interface IRVisitor
{
	void visit(AlignIR node);
	void visit(TriIR node);
	void visit(BinaryIR node);
	void visit(UnaryIR node);
	void visit(CJumpIR node);
	void visit(JumpIR node);
	void visit(CallIR node);
	void visit(LabelIR node);
	void visit(ReturnIR node);
	void visit(PushIR node);
	void visit(PopIR node);
	void visit(LoadIR node);
	void visit(StoreIR node);
	void visit(MoveIR node);

	void visit(SpecialIR node);

}
