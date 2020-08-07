package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class N5397 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int test = 0; test < testCase; test++) {
            System.out.println(test(br.readLine()));
        }
    }

    public static String test(String input) {
        int cursor = 0;
        char[] inputs = input.toCharArray();
        List<Character> answers = new ArrayList<>();

        for (char character : inputs) {
            if (character == '<') {
                cursor = (cursor <= 0) ? 0 : cursor - 1;
            } else if (character == '>') {
                cursor++;
            } else if (character == '-') {
                answers.remove(answers.size() - 1);
                cursor--;
            } else {
                cursor = (cursor > answers.size()) ? answers.size() : cursor;
                answers.add(cursor, character);
                cursor++;
            }
        }
        StringBuilder answer = new StringBuilder();
        for (char character : answers) {
            answer.append(character);
        }
        return answer.toString();
    }
}
