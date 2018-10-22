/**
 * A node for writing statements
 * 
 * @author Jaime Guevara
 */
public class NodeStmtWr extends NodeStmt 
{
	private NodeExpr expr;
	
	/**
	 * A basic constructor
	 * 
	 * @param assn
	 */
	public NodeStmtWr(NodeExpr expr) 
	{
		this.expr = expr;
	}
	
	/**
	 * Writes statements
	 * 
	 * @param env
	 * @throws EvalException
	 */
	public double eval(Environment env) throws EvalException
	{
		double a = expr.eval(env);
		System.out.println(a);
		return a;
	}
}
