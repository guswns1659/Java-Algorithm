package nts;

public class Number1 {

    public static void main(String[] args) {
        Number1 number1 = new Number1();
        System.out.println(number1.solution(new int[][]{{2,5},{3,7},{10,11}}));
        System.out.println(number1.solution(new int[][]{{3,4},{4,5},{6,7},{8,10}}));
    }

    public int solution(int[][] flowers) {

        int max = 1;
        for (int i = 0; i < flowers.length; i++) {
            for (int j = 0; j < flowers[i].length; j++) {
                max = Math.max(max, flowers[i][j]);
            }
        }

        int[] counting = new int[max];

        for (int index = 1; index < counting.length; index++) {
            for (int index2 = 0; index2 < flowers.length; index2++) {
                if (index >= flowers[index2][0] && index < flowers[index2][1]) counting[index]++;
            }
        }

        int answer = 0;
        for (int value : counting) {
            if (value > 0) answer++;
        }

        return answer;
    }
}
