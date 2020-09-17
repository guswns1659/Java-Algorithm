package backjun.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N2108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 필요한 변수 초기화
        List<Integer> numbers = new ArrayList<>();
        int sum = 0;
        int count = Integer.parseInt(br.readLine());

        for (int loop = 0; loop < count; loop++) {
            int number = Integer.parseInt(br.readLine());
            numbers.add(number);
            sum += number;
        }

        Collections.sort(numbers);

        // 전체탐색하면서 최빈값을 구하기
        List<Integer> frequents = new ArrayList<>();
        int previous = numbers.get(0);
        frequents.add(previous);
        int maxFrequent = 1;
        int repeat = 1;

        for (int index = 1; index < numbers.size(); index++) {
            int current = numbers.get(index);
            if (previous == current) {
                repeat++;
            } else {
                repeat = 1;
            }

            /*
             * 현재 최빈값이 최대 최빈값과 같다면 frequents에 추가
             * 현재 최빈값이 최대 최빈값보다 크다면 frequents를 비우고 현재 값을 넣는다. maxFrquents에 repeat를 넣는다.
             */
            if (repeat == maxFrequent) {
                frequents.add(current);
            } else if (repeat > maxFrequent) {
                frequents = new ArrayList<>();
                maxFrequent = repeat;
                frequents.add(current);
            }
            previous = current;
        }

        int frequent = 0;

        if (frequents.size() > 1) {
            Collections.sort(frequents);
            frequent = frequents.get(1);
        } else {
            frequent = frequents.get(0);
        }

        // 자바에서 정수 간 '/'는 나머지를 남기지 않기 때문에 double로 바꾼 뒤 진행한다.
        System.out.println((int)Math.round((double)sum / numbers.size()));
        System.out.println(numbers.get(numbers.size() / 2));
        System.out.println(frequent);
        // 범위가 음수가 나올 수 있기 때문에 절대값을 사용한다
        System.out.println(Math.abs(numbers.get(numbers.size() - 1) - numbers.get(0)));
    }
}
