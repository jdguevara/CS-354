/**
 * An node for relational operations
 *
 * @author Jaime Guevara
 */
public class NodeRelop extends Node
{
	private String relop;
	
	/**
	 * A basic constructor
	 * 
	 * @param pos
	 * @param relop
	 */
	public NodeRelop(int pos, String relop)
	{
		this.pos = pos;
		this.relop = relop;
	}
	
	/**
	 * Perform the relational operation
	 * 
	 * @param o1
	 * @param o2
	 * @return
	 * @throws EvalException
	 */
	@SuppressWarnings("unlikely-arg-type")
	public boolean op(double o1, double o2) throws EvalException
	{
		if(relop.equals("=="))
		{
			return o1 == o2;
		}
		else if(relop.equals("<>"))
		{
			return o1 != o2;
		}
		else if(relop.equals("<="))
		{
			return o1 <= o2;
		}
		else if(relop.equals(">="))
		{
			return o1 >= o2;
		}
		else if(relop.equals("<"))
		{
			return o1 < o2;
		}
		else if(relop.equals(">"))
		{
			return o1 > o2;
		}
		else
		{
			throw new EvalException(0, "Relational operation is not recognized");
		}
	}
}
