import java.util.LinkedList;
import java.util.List;

/**
 * Evaluate the correct exception when an error occurs.
 *
 * @author Jaime Guevara
 */
public class NodeBlock extends NodeStmt
{
	private NodeStmt stmt;
	private NodeBlock block;
	
	/**
	 * A basic constructor
	 * 
	 * @param statements
	 */
	public NodeBlock(NodeStmt stmt, NodeBlock block) 
	{
		this.stmt = stmt;
		this.block = block;
	}
	
	/**
	 * Evaluates block statements
	 * 
	 * @param env
	 * @throws EvalException
	 */
	public double eval(Environment env) throws EvalException
	{
		return stmt.eval(env);
	}
}
