package backjun.tree;

import java.util.*;
import java.io.*;

public class N14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        int count = 0;

        Map<String, Integer> map = new HashMap<>();

        // map 초기화, 1로 초기화
        for (int loop = 0; loop < N; loop++) {
            map.put(br.readLine(), 1);
        }

        for (int loop = 0; loop < M; loop++) {
            // 해당 문자열과 같은 문자열이 s에 있다면
            if (map.get(br.readLine()) != null) {
                count++;
            }
        }
        System.out.println(count);
    }
}