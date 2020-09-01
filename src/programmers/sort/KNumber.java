package programmers.sort;

import java.util.*;

public class KNumber {
    public static int[] test(int[] array, int[][] commands) {
        int[] answer;
        answer = new int[commands.length];

        for (int index = 0; index < commands.length;  index++) {
            int[] command = commands[index];
            int start = command[0] - 1;
            int end = command[1];
            int target = command[2] - 1;

            int[] splitArr = Arrays.copyOfRange(array, start, end);
            Arrays.sort(splitArr);
            answer[index] = splitArr[target];
        }

        return answer;
    }
}
