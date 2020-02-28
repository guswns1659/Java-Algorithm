package memory;

public class Prime {
    public static void main(String[] args) {
        System.out.println(isPrime());
    }

    public static int isPrime() {
        int counter = 0;
        int numberOfPrime = 0;
        int[] prime = new int[500];

        prime[numberOfPrime++] = 2;
        prime[numberOfPrime++] = 3;

        for (int number = 5; number < 1001; number+=2) {
            boolean flag = true;
            int i;
            for (i = 1; prime[i] * prime[i] <= number; i++) {
                counter+=2;
                if (number % prime[i] == 0){
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
