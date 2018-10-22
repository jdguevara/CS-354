/**
 * A node for if then statements
 * 
 * @author Jaime Guevara
 */
public class NodeStmtIfThen extends NodeStmt 
{
	private NodeBoolExpr boolexpr;
	private NodeStmt ifThenStmt;
	
	/**
	 * A basic constructor
	 * 
	 * @param boolexpr
	 * @param ifThenStmt
	 */
	public NodeStmtIfThen(NodeBoolExpr boolexpr, NodeStmt ifThenStmt)
	{
		this.boolexpr = boolexpr;
		this.ifThenStmt = ifThenStmt;
	}
	
	/**
	 * Evaluate if/then statements
	 * 
	 * @param env
	 * @throws EvalException
	 */
	public double eval(Environment env) throws EvalException
	{
		return ifThenStmt.eval(env);
	} 
}
