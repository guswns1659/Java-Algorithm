import java.util.Arrays;


public class SelfPractice {
    public static void main(String[] args) {
        System.out.println(isPrime());
        int[] ints = {1,3,5,7,9,11};
        System.out.println(binarySearch(ints, 100));
    }

    private static int binarySearch(int[] ints, int key) {
        int right = ints.length - 1;
        int left = 0;

        do {
            int middle = (left + right) / 2;
            if (ints[middle] == key) return middle;
            else if (ints[middle] > key) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        } while (left <= right);
        return -1;
    }

    private static int isPrime() {
        int counter = 0;
        int numberOfPrime = 0;
        int[] prime = new int[500];

        prime[numberOfPrime++] = 2;
        prime[numberOfPrime++] = 3;

        for (int number = 5; number < 1001; number+=2) {
            boolean flag = true;
            for (int i = 1; prime[i] * prime[i] <= number; i++) {
                counter+=2;
                if (number % prime[i] == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                counter++;
                prime[numberOfPrime++] = number;
            }
        }
        return counter;
    }
}