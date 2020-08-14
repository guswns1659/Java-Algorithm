package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2747 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(fibo(Integer.parseInt(br.readLine())));
    }

    private static int fibo(int number) {
        int a = 0;
        int b = 1;

        while (number > 0) {
            int temp = a;
            a = b;
            b = temp+b;
            number--;
        }
        return a;
    }
}
