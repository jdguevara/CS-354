/**
 *
 * @author Jaime Guevara    
 */
public class EvalException extends Exception 
{
	private int pos;
	private String msg;

	/**
	 * Basic constructor.
	 * A list of generic objects that should be added.
	 * 
	 * @param pos
	 * @param msg* 
	 */
	public EvalException(int pos, String msg) 
	{
		this.pos=pos;
		this.msg=msg;
	}

	/**
	 * Message for when exceptions are encountered
	 */
	public String toString() 
	{
		return "eval error"
				+", pos="+pos
				+", "+msg;
	}
}
