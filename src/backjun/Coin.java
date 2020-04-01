package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Coin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] countsOfCoinsAndPrice = br.readLine().split(" ");
        int countOfCoins = Integer.parseInt(countsOfCoinsAndPrice[0]);
        int price = Integer.parseInt(countsOfCoinsAndPrice[1]);

        System.out.println(countOfCoins);
        System.out.println(price);

        List<Integer> coinValues = new ArrayList<>();
        for (int count = 0; count < countOfCoins; count++) {
            int eachValue = Integer.parseInt(br.readLine());
            coinValues.add(eachValue);
        }

        coinValues.forEach(System.out::println);

        int answer = 0;
        int remainder = price;
        for (int count = coinValues.size() - 1; count >= 0; count--) {
            int quotient = remainder / coinValues.get(count);
            remainder = remainder % coinValues.get(count);
            if (quotient < 1) continue;
            else answer += quotient;
            if (remainder == 0) System.out.println(answer);
        }
    }
}
