package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String document = br.readLine();
        String word = br.readLine();
        System.out.println(test(document, word));
    }
    public static int test(String document, String word) {

        int result = 0;
        int index = 0;

        while (index + word.length() <= document.length()) {
            if (document.substring(index, index+word.length()).equals(word)) {
                result++;
                index += word.length();
            } else {
                index++;
            }
        }
        return result;
    }
}
