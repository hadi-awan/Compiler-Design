/*    EvaluationException
/**
 * This exception is thrown when an evaluation error is encountered.
 * or when a return statement is evaluated.
 * This exception should be subclassed for the return statement.
 */
public class EvaluationException extends Exception {
	
	// Generic constructor
	public EvaluationException() {
		super();
	}
	
	// Generic evaluation error
	public EvaluationException(String msg) {
		super( msg );
	}

	// Undefined operation evaluation error
	public EvaluationException(String operation, String type) {
		super(operation + " is undefined in " + type);
	}

	// Incompatible types evaluation error.
	public EvaluationException(String operation, Object op1, Object op2) {
		super("Incompatible types in "+ op1 + operation + op2);
	}
}
