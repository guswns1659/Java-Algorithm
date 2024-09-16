package backjun.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1475 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String room = br.readLine();

        room = room.replace('9', '6');

        int[] arr = new int[9];
        int max = 0;

        // room을 순회하며 각 자릿수를 배열에 추가한다.
        for (int index = 0; index < room.length(); index++) {
            arr[room.charAt(index) - '0']++;
        }

        // 9를 6으로 바꿨기 때문에 2로 나눈 뒤 반올림한 값이 필요한 셋트의 개수
        if (arr[6] != 0) {
            arr[6] = Math.round(arr[6] / 2.0f);
        }

        // 배열 순회하면서 최대값찾기
        for (int index = 0; index < arr.length; index++) {
            max = Math.max(arr[index], max);
        }

        System.out.println(max);
  }
}
