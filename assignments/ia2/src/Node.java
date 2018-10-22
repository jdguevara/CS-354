// This class, and its subclasses,
// collectively model parse-tree nodes.
// Each kind of node can be eval()-uated.

/**
 * The basic class for all the nodes parsed by the parser
 * 
 * @author Jaime Guevara
 */
public abstract class Node 
{
	protected int pos=0;

	/**
     * Necessary for functions to be implemented by our nodes
     * so that they can run properly
     * 
	 * @param env
	 * @throws EvalException
	 */
	public double eval(Environment env) throws EvalException 
	{
		throw new EvalException(pos,"cannot eval() node!");
	}
}
