// ReturnException.java - New class for handling function returns
public class ReturnException extends EvaluationException {
	private final Object returnValue;

	public ReturnException(Object value) {
		super("Return statement executed");
		this.returnValue = value;
	}

	public Object getReturnValue() {
		return returnValue;
	}
}
