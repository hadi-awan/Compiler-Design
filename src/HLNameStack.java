// HLNameStack.java
import java.util.ArrayDeque;
import java.util.ArrayList;

public class HLNameStack extends ArrayDeque<HLSymbTab> {
	private static ArrayList<HLNameStack> nameStacks = new ArrayList<>(); // Static array of name stacks, one per identifier

	// Create new stack for an identifier
	public static void createStackForName(int key) {
		// Ensure the nameStacks array is large enough to hold the new key
		while (nameStacks.size() <= key) {
			nameStacks.add(new HLNameStack());
		}
	}

	// Get stack for a specific identifier
	public static HLNameStack getStack(int key) {
		// Create stack if it doesn't exist
		if (key >= nameStacks.size()) {
			createStackForName(key);
		}
		return nameStacks.get(key);
	}

	// Push new symbol table entry onto appropriate stack
	public static void pushEntry(HLSymbTab entry) {
		int key = entry.getKey();
		// Get the stack for this identifier
		HLNameStack stack = getStack(key);
		// Push the entry onto the stack
		stack.push(entry);
		// Also record this activation
		HLActivation.getCurrentActivation().addVariable(entry);
	}

	// Pop entry from stack (called when activation is popped)
	public static void popEntry(HLSymbTab entry) {
		int key = entry.getKey();
		HLNameStack stack = getStack(key);
		// Only pop if stack is not empty
		if (!stack.isEmpty()) {
			stack.pop();
		}
	}

	// Get current value for an identifier
	public static Object getCurrentValue(int key) {
		HLNameStack stack = getStack(key);
		// Return null if stack is empty
		if (stack.isEmpty()) {
			return null;
		}
		// Return value from top of stack
		return stack.peek().getValue();
	}
}
