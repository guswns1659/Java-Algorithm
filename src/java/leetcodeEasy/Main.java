package leetcodeEasy;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        char[] chars = {'a', 'b', 'c'};
        String string = "abc";
        string.replaceFirst(String.valueOf(string.charAt(2)), "");
    }
}
