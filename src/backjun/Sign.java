package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sign {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(br.readLine());
        System.out.println("repeat : " + repeat);

        String[] signs = br.readLine().split(" ");
        Arrays.stream(signs).forEach(System.out::println);

    }
}
