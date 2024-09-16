package backjun.implementation;

import java.util.*;
import java.io.*;

public class N1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");

        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]); // 지울 인덱스

        List<Integer> nums = new ArrayList<>();
        List<Integer> answers = new ArrayList<>();

        for (int num = 1; num <= N; num++) {
            nums.add(num);
        }

        int pivot = 0;
        int k = K - 1;
        int remove = pivot + k;

        while (nums.size() != 0) {
            int removed = nums.remove(remove);
            answers.add(removed);
            pivot = remove;
            remove = pivot + k;
            if (nums.size() == 0) {
                break;
            }
            while (remove >= nums.size()) {
                remove = remove - nums.size();
            }
        }

        StringBuilder answer = new StringBuilder("<");
        answer.append(answers.get(0));

        for (int index = 1; index < answers.size(); index++) {
            answer.append(", ").append(answers.get(index));
        }
        answer.append(">");
        System.out.println(answer.toString());
    }
}