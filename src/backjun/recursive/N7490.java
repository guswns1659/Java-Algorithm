package backjun.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class N7490 {
    // 연산자가 담긴 배열을 가지고 있는 리스트
    private static List<List<Character>> operatorList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int loop = 0; loop < testCase; loop++) {
            operatorList = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());
            // 연산자를 담을 배열, 길이는 N - 1이다.
            List<Character> array = new ArrayList<>(N - 1);
            recursive(array, N - 1);

            // 1 ~ N까지 담긴 숫자 배열 초기화
            int[] integers = new int[N];
            for (int index = 0; index < N; index++) {
                integers[index] = index + 1;
            }

            for (List<Character> operators : operatorList) {
                String string = "";
                // 연산자 배열과 1 ~ N까지 숫자를 합치는 과정
                for (int index = 0; index < N - 1; index++) {
                    string += String.valueOf(integers[index]) + operators.get(index);
                }
                // 마지막 숫자를 string에 붙여준다
                string += String.valueOf(integers[N-1]);
                if (eval(string) == 0) {
                    System.out.println(string);
                }
            }
            System.out.println();
        }
    }

    /**
     * 주어진 숫자(N)에 필요한 연산을 구하는 메서드
     * 재귀라 헷갈리면 종이에 그리면서 파악하면 좋다. DFS와 비슷한 형식이다.
     */
    private static void recursive(List<Character> array, int N) {
        if (array.size() == N) {
            List<Character> copyArray = new ArrayList<>(array);
            operatorList.add(copyArray);
            return;
        }
        array.add(' ');
        recursive(array, N);
        array.remove(array.size() - 1);

        array.add('+');
        recursive(array, N);
        array.remove(array.size() - 1);

        array.add('-');
        recursive(array, N);
        array.remove(array.size() - 1);
    }

    /**
     * "2+23+3"와 같은 스트링을 계산해주는 함수.
     * 파이썬엔 eval이라는 내장함수가 있지만 자바에 없어서 직접 구현
     */
    public static int eval(String string) {
        // "1+2-3"으로 넘어오는 string의 ' '을 ''으로 바꾼다.
        string = string.replaceAll(" ", "");

        // "1-23+4+" 같은 string을 [1,-,23,+,4]로 만들어주는 함수
        List<String> expression = toCorrectExpression(string);

        // "[1, -, 23, +, 4, +, 5, +, 6, +, 7]"으로 넘어오는 expression의 첫번째 숫자를 sum에 더한다
        int sum = Integer.parseInt(expression.get(0));

        // 연산자를 담고 있을 스택
        Stack<String> stack = new Stack<>();

        // exprssion 2번째 인덱스부터 반복문돌면서 합을 계산한다
        for (int index = 1; index < expression.size(); index++) {
            String character = expression.get(index);
            if (isNumber(character)) {
                String operator = stack.pop();
                switch (operator) {
                    case "+":
                        sum += Integer.parseInt(character);
                        break;
                    case "-":
                        sum -= Integer.parseInt(character);
                        break;
                }
            } else {
                stack.push(character);
            }
        }
        return sum;
    }

    /** eval() 내 메서드
     * "2+23+4"같은 String을 [2,23,4]로 변환
     */
    public static List<String> toCorrectExpression(String string) {
        // 연속된 숫자의 자릿수를 기억하는 변수
        int digit = 0;
        List<String> expression = new ArrayList<>();

        for (int index = 0; index < string.length(); index++) {
            char character = string.charAt(index);
            if (isNumber(character)) {
                // 한자리수 이상인 숫자라면 ex. 23
                if (digit > 0) {
                    String last = expression.remove(expression.size() - 1);
                    String newNumber = last + character;
                    digit++;
                    expression.add(newNumber);
                } else {
                    digit++;
                    expression.add(character + "");
                }
            } else {
                digit = 0;
                expression.add(character + "");
            }
        }
        return expression;
    }

    public static boolean isNumber(char character) {
        return character != '+' && character != '-' && character != ' ';
    }

    public static boolean isNumber(String character) {
        return !character.equals("+") && !character.equals("-");
    }
}
