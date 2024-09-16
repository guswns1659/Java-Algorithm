package backjun;

import java.io.*;
import java.util.ArrayList;

public class Sign {
    private static boolean[] used = new boolean[10];
    private static int k;
    private static String[] str;
    private static ArrayList<String> result;

    public static void solution(int cnt, int prior, String t) {
        if (cnt == k) {
            result.add(t);
            used[prior] = false;
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (used[i])
                continue;
            if (i == prior)
                continue;
            if (str[cnt].equals(">")) {
                if (prior < i) {
                    continue;
                }
            } else if (str[cnt].equals("<")) {
                if (prior > i) {
                    continue;
                }
            }
            used[i] = true;
            solution(cnt + 1, i, t + i);
        }
        used[prior] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        k = Integer.parseInt(br.readLine());
        str = br.readLine().split(" ");
        result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            used[i] = true;
            solution(0, i, String.valueOf(i));
        }
        bw.write(result.get(result.size() - 1) + "\n");
        bw.write(result.get(0) + "");
        bw.flush();
        bw.close();

    }
}