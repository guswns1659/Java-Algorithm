package doit.chap2;

public class Practice9 {
    public static void main(String[] args) {
        Practice9 practice9 = new Practice9();
        practice9.isPrime();
    }

    // n이 소수인지 판별하려면 n의 제곱근 이하 소수로 안 나눠진다.
    public int isPrime() {
        int counter = 0;
        int numberOfPrime = 0;
        int[] prime = new int[500];

        prime[numberOfPrime++] = 2;

        for (int number = 3; number < 1001; number += 2) {
            int i;
            for (i = 1; i < numberOfPrime; i++) {
                counter++;
                if (number % prime[i] == 0) break;
            }
            if (i == numberOfPrime) prime[numberOfPrime++] = number;
        }
        return counter;
    }
}
