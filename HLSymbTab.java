// Represents a symbol table entry and manages symbol table functionality
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class HLSymbTab {
	// Add storage for functions
	public static class Function {
		SimpleNode body;
		List<Integer> paramKeys;
		HLActivation definitionScope; // Where the function was defined

		Function(SimpleNode body, List<Integer> paramKeys, HLActivation definitionScope) {
			this.body = body;
			this.paramKeys = paramKeys;
			this.definitionScope = definitionScope;
		}
	}


	// Static table for global variables (used in 7Cb)
	private static ArrayList<HLSymbTab> globalTable = new ArrayList<>();
	private static final HLActivation globalScope;
	private static Map<Integer, Function> functionTable = new HashMap<>();

	static {
		// Initialize global scope
		globalScope = new HLActivation(null);
	}

	// Instance fields for each symbol table entry
	private final int key;		// Key from name table
	private Object value;		// Current value of the variable
	private String type;		// "bool", "num", or "set"
	private String name;

	// Creates a new symbol table entry
	public HLSymbTab(int key, String type) {
		this.key = key;
		this.type = type;
		this.name = IdentifierToken.getName(key);
		
		// Set default value based on type
		if (type.equals("typebool")) {
			this.value = Boolean.FALSE;
		}
		else if (type.equals("typeset")) {
			this.value = new HLSet();
		}
		else if (type.equals("typenum")){
			this.value = new HLNumber(0);
		}
	}

	// Called when new identifier is encountered
	public static void newIdName(int key) {
		// Ensure space in global table
		while (globalTable.size() <= key) {
			globalTable.add(null);
		}
	}

	// Gets the symbol table entry for a given key
	public static HLSymbTab getEntry(int key) {
		if (key >= 0 && key < globalTable.size()) {
			return globalTable.get(key);
		}
		return null;
	}

	// Value access and modification
	public void setValue(Object value) {
		this.value = value;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Object getValue() {
		return value;
	}

	public String getType() {
		return type;
	}

	public int getKey() {
		return key;
	}

	public String getName() {
		return name; 
	}
	
	// Declares a new variable with given type and initial value
	public static void declareVariable(Integer idKey, String type, Object initialValue) {
		// Create new entry with type and initial value
		HLSymbTab entry = new HLSymbTab(idKey, type);
		if (initialValue != null) { 
			entry.setValue(initialValue);
		}

		HLActivation currentActivation = HLActivation.getCurrentActivation();
		if (currentActivation == null) {
			// Global scope
			while (globalTable.size() <= idKey) {
				globalTable.add(null);
			}
			globalTable.set(idKey, entry);
		}
		else {
			// Local scope - add to current activation
			currentActivation.addVariable(entry);
		}
	}

	// Assigns a value to an existing variable
	public static void assignVariable(Integer idKey, Object value) throws EvaluationException {
		HLActivation current = HLActivation.getCurrentActivation();

		if (current == null || current == globalScope) {
			// Global scope
			if (idKey >= globalTable.size() || globalTable.get(idKey) == null) {
				declareVariable(idKey, inferType(value), value);
			}
			else {
				globalTable.get(idKey).setValue(value);
				HLSymbTab entry = globalScope.getVariable(idKey);
				if (entry != null) {
					entry.setValue(value);
				}
			}
			return;
		}

		// Look for variable in current scope first
		HLSymbTab localEntry = current.getVariable(idKey);
		if (localEntry != null) {
			localEntry.setValue(value);
			return;
		}

		// Check lexical parent chain
		HLActivation scope = current.getLexicalParent();
		while (scope != null) {
			HLSymbTab entry = scope.getVariable(idKey);
			if (entry != null) {
				entry.setValue(value);
				return;
			}
			scope = scope.getLexicalParent();
		}

		// If not found anywhere, create in current scope
		declareVariable(idKey, inferType(value), value);
	}

	// Gets the current value of a variable
	public static Object getVariableValue(Integer idKey) throws EvaluationException {
		HLActivation current = HLActivation.getCurrentActivation();

		if (current == null) {
			// Global scope lookup
			if (idKey >= globalTable.size() || globalTable.get(idKey) == null) {
				throw new EvaluationException("Undefined variable: " + IdentifierToken.getName(idKey));
			}
			return globalTable.get(idKey).getValue();
		}

		// First look for the variable in the current activation
		HLSymbTab localEntry = current.getVariable(idKey);
		if (localEntry != null) {
			return localEntry.getValue();
		}

		// For static scoping, check lexical parent chain before globals
		HLActivation scope = current.getLexicalParent();
		while (scope != null) {
			HLSymbTab entry = scope.getVariable(idKey);
			if (entry != null) {
				return entry.getValue();
			}
			scope = scope.getLexicalParent();
		}

		// Finally check global scope
		if (idKey < globalTable.size() && globalTable.get(idKey) != null) {
			Object value = globalTable.get(idKey).getValue();
			return globalTable.get(idKey).getValue();
		}

		throw new EvaluationException("Undefined variable: " + IdentifierToken.getName(idKey));
	}

	// Store a function definition
	public static void declareFunction(Integer fnKey, SimpleNode body, List<Integer> paramKeys, HLActivation parentActivation) {
		Function fn = new Function(body, paramKeys, parentActivation);
		functionTable.put(fnKey, fn);
	}

	private static String inferType(Object value) {
		if (value instanceof Boolean) return "typebool";
		if (value instanceof HLSet) return "typeset";
		return "typenum";
	}

	// Get function info for execution
	public static Function getFunction(Integer fnKey) throws EvaluationException {
		Function fn = functionTable.get(fnKey);
		if (fn == null) { throw new EvaluationException("Undefined function: " + IdentifierToken.getName(fnKey)); }
		return fn;
	}
}
