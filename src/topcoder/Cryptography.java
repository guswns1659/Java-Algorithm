package topcoder;

public class Cryptography {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        System.out.println(encrypt(numbers));
    }

    public static long encrypt(int[] numbers) {

        long answer = 0;

        for (int index = 0; index < numbers.length; index++) {
            int temperary = numbers[index] + 1;
            for (int count = 0; count < numbers.length; count++) {
                if (count == index) continue;
                else {
                    temperary *= numbers[count];
                }
            }
            answer = Math.max(temperary, answer);
        }
        return answer;
    }
}
