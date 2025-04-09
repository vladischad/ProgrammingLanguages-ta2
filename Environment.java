import java.util.HashMap;
import java.util.Map;

// This class provides a stubbed-out environment.
// You are expected to implement the methods.
// Accessing an undefined variable should throw an exception.

// Hint!
// Use the Java API to implement your Environment.
// Browse:
//   https://docs.oracle.com/javase/tutorial/tutorialLearningPaths.html
// Read about Collections.
// Focus on the Map interface and HashMap implementation.
// Also:
//   https://www.tutorialspoint.com/java/java_map_interface.htm
//   http://www.javatpoint.com/java-map
// and elsewhere.

/**
 * The Environment class manages variable storage and retrieval for the interpreter.
 * It also generates C code declarations for the variables used in the program.
 */
public class Environment {

	private Map<String, Integer> map = new HashMap<>();

	/**
     * Stores a variable and its value in the environment.
     * @param var The variable name.
     * @param val The value to store.
     * @return The stored value.
     */
	public int put(String var, int val) {
		map.put(var, val);
		return val;
	}

	/**
     * Retrieves the value of a given variable from the environment.
     * @param pos The position in the source code where the variable is accessed.
     * @param var The variable name.
     * @return The value of the variable.
     * @throws EvalException If the variable is undefined.
     */
	public int get(int pos, String var) throws EvalException {
		if (!map.containsKey(var)) {
			throw new EvalException(pos, "undefined variable: " + var);
		}
		return map.get(var);
	}

	/**
     * Generates C code for variable declarations based on the stored environment.
     * @return A string containing C variable declarations.
     */
	public String toC() {
		if (map.isEmpty()) return "";
		StringBuilder sb = new StringBuilder("int ");
		boolean first = true;
		for (String var : map.keySet()) {
			if (!first) sb.append(", ");
			sb.append(var);
			first = false;
		}
		sb.append(";\n");
		return sb.toString();
	}
}