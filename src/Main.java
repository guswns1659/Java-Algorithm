import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();

        int result = 0;
        int patternCount = 0;

        for (int index = 1; index < s.length - 1; index++) {
            if (s[index - 1] == 'I' && s[index] == 'O' && s[index+1] == 'I') {
                patternCount++;
                if (patternCount == n) {
                    patternCount--;
                    result++;
                }
                index++;
            } else {
                patternCount = 0;
            }
        }
        System.out.println(result);
    }
}