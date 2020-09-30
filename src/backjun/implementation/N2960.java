package backjun.implementation;

import java.util.*;
import java.io.*;

public class N2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        System.out.println(solution(N, K));
    }

    private static int solution(int N, int K) {
        // 2 ~ N 초기화
        List<Integer> numbers = new ArrayList<>();
        for (int num = 2; num < N + 1; num++) {
            numbers.add(num);
        }

        int count = 0;
        List<Integer> removed = new ArrayList<>();

        // k번째 소수를 찾는 과정
        do {
            int first = numbers.remove(0);
            count++;
            removed.add(first);

            for (int index = 0; index < numbers.size(); index++) {
                int num = numbers.get(index);
                // 지운 횟수가 k라면 removed의 마지막 원소를 리턴
                if (count == K) {
                    return removed.get(removed.size() - 1);
                }
                // 처음 지운 숫자의 배수라면 removed에 추가
                if (num % first == 0) {
                    int remove = numbers.remove(index);
                    count++;
                    removed.add(remove);
                }
            }
        } while (count < K);
        return removed.get(removed.size() - 1);
    }
}
