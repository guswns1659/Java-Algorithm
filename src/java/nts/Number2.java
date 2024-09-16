package nts;

import java.util.ArrayList;

class Combination {
    private int n;
    private int r;
    private int[] now;
    private ArrayList<ArrayList<Integer>> result;

    public ArrayList<ArrayList<Integer>> getResult() {
        return result;
    }

    public Combination(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<ArrayList<Integer>>();
    }

    public void combination(int[] arr, int depth, int index, int target) {
        if (depth == r) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < now.length; i++) {
                temp.add(arr[now[i]]);
            }
            result.add(temp);
            return;
        }
        if (target == n) return;
        now[index] = target;
        combination(arr, depth + 1, index + 1, target + 1);
        combination(arr, depth, index, target + 1);
    }
}


public class Number2 {
    public static void main(String[] args) {
        Number2 number2 = new Number2();
        System.out.println(number2.solution(1));
        System.out.println(number2.solution(2));
        System.out.println(number2.solution(4));
        System.out.println(number2.solution(5));
    }

    public int solution(int N) {
        if (N <= 2) {
            return N;
        }
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        int r = 2;
        Combination comb = new Combination(arr.length, r);
        comb.combination(arr, 0, 0, 0);
        ArrayList<ArrayList<Integer>> result = comb.getResult();

        int answer = result.size();
        return answer;
    }
}
