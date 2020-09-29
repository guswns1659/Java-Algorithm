package street11;

import java.util.Arrays;

public class Number3 {
    public static void main(String[] args) {
        Number3 number3 = new Number3();
        System.out.println(number3.solution(new int[]{1,2,1})); // 2
        System.out.println(number3.solution(new int[]{2,1,4,4})); // 1
        System.out.println(number3.solution(new int[]{6,2,3,5,6,3})); // 4
        System.out.println(number3.solution(new int[]{1, 1, 1})); // 3
        System.out.println(number3.solution(new int[]{1})); // 0
        System.out.println(number3.solution(new int[]{4,3,2,1})); // 0
        System.out.println(number3.solution(new int[]{3,3,3})); // 3
        System.out.println(number3.solution(new int[]{10,10,10})); // ?
    }

    public int solution(int[] A) {
        Arrays.sort(A);
        int count = 0;
        // 첫문자가 1이 아니면 1로 바꿔준다.
        if (A[0] != 1) {
            int sub = A[0] - 1;
            count += sub;
            A[0] = 1;
        }

        for (int index = 1; index < A.length; index++) {
            // 만약 앞 숫자와 같으면 +1한다
            if (A[index - 1] == A[index]) {
                A[index] += 1;
                count++;

            } else if (A[index - 1] > A[index]) {
                while (A[index] - A[index - 1] != 1) {
                    A[index] += 1;
                    count++;
                }
            } else {
                while (A[index] - A[index - 1] > 1) {
                    A[index] -= 1;
                    count++;
                }
            }

        }
        return count > 1000000000 ? -1 : count;
    }
}
