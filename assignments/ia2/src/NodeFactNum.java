/**
 * An node for facts that are numbers
 *
 * @author Jaime Guevara
 */
public class NodeFactNum extends NodeFact 
{
	private String num;

	/**
	 * A basic constructor
	 * 
	 * @param num
	 */
	public NodeFactNum(String num) 
	{
		this.num=num;
	}

	/**
	 * Evaluate the node's number
	 * 
	 * @return num.eval(env)
	 */
	public double eval(Environment env) throws EvalException
	{
		return Integer.parseInt(num);
	}
}
