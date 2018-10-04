/**
 * This is a class to help with unary minus identification
 * @author Jaime Guevara
 *
 */
public class NodeSign extends NodeFact {
	private String sign;

    public NodeSign(String sign) {
	this.sign=sign;
    }

    public int eval(Environment env) throws EvalException {
	return Integer.parseInt(sign);
    }
}
