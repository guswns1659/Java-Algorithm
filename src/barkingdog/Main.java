package barkingdog;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.func4(5));
        System.out.println(main.func4(97615282));
        System.out.println(main.func4(1024));
    }

    public long func1(int N) {
        long sum = 0;

        for (int num = 1; num < N + 1; num++) {
            if ((num % 3 == 0) || (num % 5 == 0)) {
                sum += num;
            }
        }
        return sum;
    }

    public long func2(int[] arr, int N) {
        for (int i = 0; i < N; i++) {
            int num = arr[i];
            int finding = 100 - num;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (arr[j] == finding) return 1;
            }
        }
        return 0;
    }

    public long func3(int N) {
        double num = Math.sqrt(N);
        String string = String.valueOf(num);
        if (string.charAt(string.length()-1) == '0') {
            return 1;
        }
        return 0;
    }

    public long func4(int N) {
        String num = Integer.toBinaryString(N);
        StringBuilder string = new StringBuilder();
        for (int loop = 0; loop < num.length(); loop++) {
            string.append("1");
        }
        // 2진수로 변환 후 or 연산자를 사용한다
        int result = Integer.parseInt(num,2) | Integer.parseInt(string.toString(),2);
        string = new StringBuilder();
        for (int loop = 0; loop < num.length() - 1; loop++) {
            string.append("1");
        }

        result = Integer.parseInt(Integer.toBinaryString(result), 2) ^ Integer.parseInt(string.toString(), 2);
        return result;
    }
}
