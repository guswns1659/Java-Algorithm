package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String word = br.readLine();
        System.out.println(test(input, word));
    }
    public static int test(String input, String word) {

        int count = 0;

        for (int index = 0; index < input.length(); index += word.length()) {
            if (index + word.length() -1 >= input.length()) {
                break;
            }
            if (input.substring(index, index+word.length()).equals(word)) {
                count++;
            }
        }
        return count;
    }
}
