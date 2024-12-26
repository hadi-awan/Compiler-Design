// HLActivation.java
import java.util.ArrayDeque;
import java.util.Map;
import java.util.HashMap;

public class HLActivation {
	private static ArrayDeque<HLActivation> activationStack = new ArrayDeque<>(); // The single activation stack for the program
	private Map<Integer, HLSymbTab> variables;  // Maps variable keys to their symbol table entries in this activation record
	private final HLActivation lexicalParent;  // Reference to lexical parent scope for static scoping

	// Constructor creates new activation record with given lexical parent
	public HLActivation(HLActivation lexicalParent) {
		this.variables = new HashMap<>();
		this.lexicalParent = lexicalParent;
		activationStack.push(this);
	}

	// Returns the lexical parent for static scope chain traversal
	public HLActivation getLexicalParent() {
		return lexicalParent;
	}

	// Adds a variable to this activation record
	public void addVariable(HLSymbTab entry) {
		variables.put(entry.getKey(), entry);
	}

	// Retrieves a variable from this activation or its lexical parents
	public HLSymbTab getVariable(Integer key) {
		// First check local variables
		HLSymbTab entry = variables.get(key);
		if (entry != null) {
			return entry;
		}
		// Then check lexical parent (static scoping)
		if (lexicalParent != null) {
			return lexicalParent.getVariable(key);
		}
		return null;
	}


	// Removes this activation from the stack
	public void pop() {
		activationStack.pop();
	}	
	
	// Returns the currently active activation record
	public static HLActivation getCurrentActivation() {
		return activationStack.peek();
	}

	// Creates new activation record with no lexical parent
	public static HLActivation pushNewActivation() {
		return new HLActivation(null);
	}

	// Creates new activation with specified lexical parent
	public static HLActivation pushWithLexicalScope(HLActivation lexicalParent) {
		return new HLActivation(lexicalParent);
	}
}
