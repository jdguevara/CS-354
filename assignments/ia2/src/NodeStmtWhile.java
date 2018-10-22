/**
 * A node for while statements
 * 
 * @author Jaime Guevara
 */
public class NodeStmtWhile extends NodeStmt 
{
	private NodeBoolExpr boolexpr;
	private NodeStmt whileStmt;
	
	/**
	 * A basic constructor
	 * 
	 * @param boolexpr
	 * @param whileStmt
	 */
	public NodeStmtWhile(NodeBoolExpr boolexpr, NodeStmt whileStmt) 
	{
		this.boolexpr = boolexpr;
		this.whileStmt = whileStmt;
	}
	
	/**
	 * Evaluates the while statement
	 * 
	 * @param env
	 * @throws EvalException
	 */
	public double eval(Environment env) throws EvalException
	{
		if(boolexpr.eval(env))
		{
			whileStmt.eval(env);			
		}
		return whileStmt.eval(env);
	}
}
