/**
 * Node containing the grammar for facts that are expressions 
 *
 * @author Jaime Guevara
 */
public class NodeFactExpr extends NodeFact 
{
	private NodeExpr expr;

	/**
	 * Set this environment's current expression
	 * 
	 * @param expr
	 */
	public NodeFactExpr(NodeExpr expr) {
		this.expr=expr;
	}

	/**
	 * Evaluate the expression
	 * 
	 * @return expr.eval(env)
	 */
	public double eval(Environment env) throws EvalException 
	{
		return expr.eval(env);
	}

}
