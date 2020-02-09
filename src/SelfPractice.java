import java.util.Arrays;

public class SelfPractice {
    public static void main(String[] args) {
        System.out.println(isPrime());
        int[] ints = {1,2,3,4,5,6,7};
        System.out.println(binarySearchTest(ints, 7));
        System.out.println(Arrays.binarySearch(ints, 7));
    }

    private static int binarySearchTest(int[] ints, int key) {
        int left = 0;
        int right = ints.length - 1;

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
