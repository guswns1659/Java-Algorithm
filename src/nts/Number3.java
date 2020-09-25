package nts;

public class Number3 {
    public static void main(String[] args) {
        Number3 number3 = new Number3();
        System.out.println(number3.solution(new int[]{2,2,2,3}));
        System.out.println(number3.solution(new int[]{6,5,7,3,4,2}));
    }

    public int solution(int[] histogram) {
        int min = 1;
        int max = (histogram.length - 1);
        int answer = 0;

        while (max >= min) {
            int mid = (max + min) / 2;

            for (int index = 0; index < histogram.length; index++) {
                int index2 = index + mid;
                if (index2 >= histogram.length) break;
                if (histogram[index] >= histogram[index2]) {
                    int minArea = histogram[index2];
                    int value = (index2 - index - 1) * minArea;
                    max = Math.max(answer,value);
                } else {
                    int minArea = histogram[index];
                    int value = (index2 - index - 1) * minArea;
                    max = Math.max(answer,value);
                }
            }
            min = mid + 1;
        }
        return answer;
    }
}
