/**
 * An node for the facts that are identifiersr
 *
 * @author Jaime Guevara
 */
public class NodeFactId extends NodeFact 
{
	private String id;

	/**
	 * A basic contructor
	 * 
	 * @param pos
	 * @param id
	 */
	public NodeFactId(int pos, String id) 
	{
		this.pos=pos;
		this.id=id;
	}

	/**
	 * Evaluate the id from the environment
	 * 
	 * @return env.get(pos,id)
	 * @throws EvalException
	 */
	public double eval(Environment env) throws EvalException 
	{
		return env.get(pos,id);
	}
}
