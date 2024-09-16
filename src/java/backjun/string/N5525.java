package backjun.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(test(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), br.readLine()));
    }
    public static int test(int inputPattern, int lengthOfString, String word) {

        int count = 0;
        int patternCount = 1;

        for (int index = 1; index < word.length(); index++) {
            if (word.charAt(index - 1) == 'I' && word.charAt(index) == 'O' && word.charAt(index+1) == 'I') {
                if (patternCount == inputPattern) {
                    count++;
                } else {
                    patternCount++;
                }
                index++;
            } else {
                patternCount = 1;
            }
        }
        return count;
    }
}
