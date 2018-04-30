package MxCompiler.AST;

abstract public class ASTNode extends Object
{
	ASTNode(){}
	abstract public SourcePosition position();

	//abstract public <S,E> S accept(ASTVisitor<S,E> visitor);
}
