/**
 * A node containing terms, add operations, and expressions.
 * 
 * @author Jaime Guevara
 */
public class NodeExpr extends Node 
{
	private NodeTerm term;
	private NodeAddop addop;
	private NodeExpr expr;

	/**
	 * Constructor
	 * 
	 * @param term
	 * @param addop
	 * @param expr
	 */
	public NodeExpr(NodeTerm term, NodeAddop addop, NodeExpr expr) 
	{
		this.term=term;
		this.addop=addop;
		this.expr=expr;
	}

	/**
	 * Allows an expression to have another expression
	 * @param expr
	 */
	public void append(NodeExpr expr)
	{
		if (this.expr==null) 
		{
			this.addop=expr.addop;
			this.expr=expr;
			expr.addop=null;
		} 
		else
		{
			this.expr.append(expr);
		}
	}

	/**
	 * Evaluates our expression
	 * 
	 * @return expr==null
	 */
	public double eval(Environment env) throws EvalException {
		return expr==null
				? term.eval(env)
						: addop.op(expr.eval(env),term.eval(env));
	}

}
