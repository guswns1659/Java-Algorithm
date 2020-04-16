package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LostBracket {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split("");
        List<String> list = new ArrayList<>();
        StringBuilder number = new StringBuilder();

        for (String each : tokens) {
            if (each.equals("+") || each.equals("-")) {
                list.add(number.toString());
                number = new StringBuilder();
                list.add(each);
            } else {
                number.append(each);
            }
        }
        list.add(number.toString());

        list.forEach(System.out::println);
    }
}
