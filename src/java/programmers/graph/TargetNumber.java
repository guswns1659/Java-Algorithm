package programmers.graph;

import java.util.Arrays;

public class TargetNumber {

    public static void main(String[] args) {
        int[] numbers = new int[5];
        Arrays.fill(numbers, 1);
        int target = 3;

        System.out.println(new TargetNumber().solution(numbers, target));
    }

    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    public int dfs(int[] numbers, int target, int index, int sum) {
        if (index == numbers.length) {
            return (sum == target) ? 1 : 0;
        }
        return dfs(numbers, target, index+1, sum + numbers[index])
                + dfs(numbers, target, index+1, sum - numbers[index]);
    }
}
