/**
 * An node for evaluating operations that utilize boolean values
 *
 * @author Jaime Guevara
 */
public class NodeBoolExpr 
{
	private final NodeExpr leftSide;
	private final NodeRelop relOperator;
	private final NodeExpr rightSide;
	
	/**
	 * A constructor 
	 * 
	 * @param leftSide
	 * @param relOperator
	 * @param rightSide
	 */
	public NodeBoolExpr(NodeExpr leftSide, NodeRelop relOperator, NodeExpr rightSide)
	{
		this.leftSide = leftSide;
		this.relOperator = relOperator;
		this.rightSide = rightSide;
	}
	
	/**
	 * Evaluates the boolean expression
	 * 
	 * @param env
	 * @return
	 * @throws EvalException
	 */
	public boolean eval(Environment env) throws EvalException
	{
		return relOperator.op(leftSide.eval(env), rightSide.eval(env));
	}
}
