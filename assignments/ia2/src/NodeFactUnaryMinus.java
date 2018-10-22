/**
 * Assists with evaluating unary minus
 * 
 * @author Jaime Guevara
 */
public class NodeFactUnaryMinus extends NodeFact 
{
	private NodeFact fact;

	/**
	 * A basic constructor
	 * 
	 * @param unaryMinus
	 */
	public NodeFactUnaryMinus(NodeFact fact) 
	{
		this.fact=fact;
	}

	/**
	 * Evaluates the unary value
	 * 
	 * @param env 
	 * @return fact.eval(env) * (-1) - return the number to the negative 
	 * @throws EvalException
	 */
	public double eval(Environment env) throws EvalException 
	{
		return fact.eval(env) * (-1);
	}
}
