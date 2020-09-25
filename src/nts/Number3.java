package nts;

public class Number3 {
    public static void main(String[] args) {
        Number3 number3 = new Number3();
        System.out.println(number3.solution(new int[]{2,2,2,3}));
        System.out.println(number3.solution(new int[]{6,5,7,3,4,2}));
    }

    public int solution(int[] histogram) {
        int max = 0;
        for (int i = 0; i < histogram.length; i++) {
            for (int j = 0; j < histogram.length; j++) {
                if (i >= j) continue;
                if (i + 1 == j) continue;
                if (histogram[i] >= histogram[j]) {
                    int min = histogram[j];
                    int value = (j - i - 1) * min;
                    max = Math.max(max,value);
                } else {
                    int min = histogram[i];
                    int value = (j - i - 1) * min;
                    max = Math.max(max,value);
                }
            }
        }

        return max;
    }
}
