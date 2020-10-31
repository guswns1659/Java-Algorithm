package programmerswinterintern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Number1 {
    public static void main(String[] args) {
        Number1 number1 = new Number1();
//        System.out.println(number1.solution(6, new int[][]{{1,3,1},{3,5,0},{5,4,0},{2,5,0}}));
        System.out.println(number1.solution(7, new int[][]{{5,6,0},{1,3,1},{1,5,0},{7,6,0},{3,7,1},{2,5,0}}));

    }

    public String solution(int n, int[][] delivery) {

        int[] product = new int[n+1];
        List<int[]> oneMore = new ArrayList<>();

        // product 초기화 : -1
        Arrays.fill(product, -1);


        // delivery 순회
        for (int[] info : delivery) {
            int a = info[0];
            int b = info[1];
            int c = info[2];

            if (c == 1) {
                product[a] = 1;
                product[b] = 1;
            } else {
                // 배송 불가면(0) 다시 시작
                oneMore.add(info);
                if (product[a] == 1) {
                    // change = true;
                    product[b] = 0;
                } else if (product[a]==0) {
                   // 그대로
                } else {
                    if (product[b] == 1) {
                        // change = true;
                        product[a] = 0;
                    }
                }
            }
        }

        // oneMore 순회
        while(true) {
            boolean change = false;

            for (int[] info : oneMore) {
                int a = info[0];
                int b = info[1];
                if (product[a] == 1) {
                    if (product[b] != 0) {
                        product[b] = 0;
                        change = true;
                    };
                } else if (product[a]==0) {
                    // 그대로
                } else {
                    if (product[b] == 1) {
                        if (product[a] != 0) {
                            product[a] = 0;
                            change = true;
                        };
                    }
                }
            }
            if (!change) {
                break;
            }
        }

        // answer
        StringBuilder answer = new StringBuilder();
        for (int index = 1; index < n+1; index++) {
            int stock = product[index];
            if (stock == 1) answer.append("O");
            else if (stock == 0) answer.append("X");
            else answer.append("?");
        }
        return answer.toString();
    }
}
