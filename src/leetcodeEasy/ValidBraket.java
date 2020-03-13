package leetcodeEasy;

import java.util.*;

public class ValidBraket {
	private static HashMap<Character, Character> hashMap = new HashMap<>();
	private static final List<Character> OPEN_BRAKET = Arrays.asList('(', '{', '[');
	private static final List<Character> CLOSED_BRAKET = Arrays.asList(')', '}', ']');
	private static Stack<Character> stack = new Stack<>();

	public static boolean isValid(String s) {
	    stack.clear();
		bulidHashMap();
		char[] chars = s.toCharArray();
		if (chars.length == 0) return true;
		for (char each : chars) {
			if (OPEN_BRAKET.contains(each)) {
				stack.push(each);
			} else if (CLOSED_BRAKET.contains(each)) {
				if (stack.isEmpty()) return false;
				char openBraket = stack.pop();
				if (hashMap.get(each) == openBraket) continue;
				return false;
			} else {
				return false;
			}
		}
		return stack.isEmpty();
	}

	public static void bulidHashMap() {
		hashMap.put(')', '(');
		hashMap.put('}', '{');
		hashMap.put(']', '[');
	}
}
