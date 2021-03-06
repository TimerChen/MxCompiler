package MxCompiler.Type;

public class Type extends Object
{
	static int idNumber = 0;

	int id;
	int size;
	private Type next;

	public Type()
	{
		id = idNumber++;
		size = 0;
		next = null;
	}

	public int size()
	{
		return size;
	}

	public void setSize(int size)
	{
		this.size = size;
	}

	public Type next()
	{
		if(next == null)
			next = new TypeArray(this);
		return next;
	}
	public String toRootString()
	{
		return toString();
	}
}



