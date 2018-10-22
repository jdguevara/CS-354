/**
 * A node that helps with statement assignment
 * 
 * @author Jaime Guevara
 *
 */
public class NodeStmtAssn extends NodeStmt
{
	private String id;
	private NodeExpr expr;

	/**
	 * A basic constructor
	 * 
	 * @param id
	 * @param expr
	 */
	public NodeStmtAssn(String id, NodeExpr expr) 
	{
		this.id=id;
		this.expr=expr;
	}

	/**
	 * Evaluate the given assignment
	 * 
	 * @return env.put(id, expr.eval(env))
	 */
	public double eval(Environment env) throws EvalException 
	{
		return env.put(id, expr.eval(env));
	}
}
