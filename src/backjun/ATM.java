package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int people = Integer.parseInt(br.readLine());
        String[] eachTimes = br.readLine().split(" ");

        List<Integer> numbers = new ArrayList<>();
        for (String each : eachTimes) {
            numbers.add(Integer.parseInt(each));
        }
        Collections.sort(numbers);
        int sum = 0;
        for (Integer each : numbers) {
            sum += people-- * each;
        }
        System.out.println(sum);
        br.close();
    }
}
