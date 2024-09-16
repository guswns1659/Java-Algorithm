package backjun.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N10815 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cardCount = Integer.parseInt(br.readLine());
        String[] cardNumberString = br.readLine().split(" ");
        List<Integer> cardNumbers = new ArrayList<>(cardCount);

        for (String cardNumber : cardNumberString) {
            cardNumbers.add(Integer.parseInt(cardNumber));
        }

        int testCaseCount = Integer.parseInt(br.readLine());
        String[] testCaseString = br.readLine().split(" ");
        List<Integer> testCases = new ArrayList<>(testCaseCount);

        for (String testCase : testCaseString) {
            testCases.add(Integer.parseInt(testCase));
        }

        System.out.println(test(cardNumbers, testCases));
    }

    public static String test(List<Integer> cardNumbers, List<Integer> testCases) {
        Collections.sort(cardNumbers);
        StringBuilder answer = new StringBuilder();

        for (int testCase : testCases) {
            int isExisted = Collections.binarySearch(cardNumbers, testCase);
            if (isExisted >= 0) {
                answer.append("1 ");
            } else {
                answer.append("0 ");
            }
        }

        return answer.deleteCharAt(answer.length()-1).toString();
    }
}
