package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class N11004 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());

        List<Integer> data = new ArrayList<>();
        stringTokenizer = new StringTokenizer(br.readLine());

        for (int loop = 0; loop < n; loop++) {
            data.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        Collections.sort(data);
        System.out.println(data.get(k - 1));
    }
}
