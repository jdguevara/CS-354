import java.util.Scanner;
/**
 * A node for reading statements
 * 
 * @author Jaime Guevara
 */
public class NodeStmtRd extends NodeStmt 
{
	private String id;
	static Scanner scan;
	/**
	 * A basic constructor
	 * 
	 * @param id
	 */
	public NodeStmtRd(String id) 
	{
		this.id = id;
	}

	/**
	 * Evaluates the read statement
	 * 
	 * @param env
	 * @throws EvalException
	 */
	public double eval(Environment env) throws EvalException
	{
		scan = new Scanner(System.in);
		double value = scan.nextDouble();
		return env.put(id, value);
	}	
}
