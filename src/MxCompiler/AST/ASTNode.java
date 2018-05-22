package MxCompiler.AST;

abstract public class ASTNode extends Object
{
	static private int totalNumber = 0;
	private int hashNumber;
	abstract public SourcePosition position();

	ASTNode()
	{
		hashNumber = totalNumber++;
	}

	@Override
	public int hashCode()
	{
		//return totalNumber;
		return super.hashCode();
	}
	//abstract public <S,E> S accept(ASTVisitor<S,E> visitor);
}
