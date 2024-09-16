package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rope {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int countOfRope = Integer.parseInt(br.readLine());
        List<Integer> ropes = new ArrayList<>();
        for (int count = 0; count < countOfRope; count++) {
            ropes.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(ropes);
        int max = 0;
        int count = countOfRope;
        for (int each : ropes) {
            int value = each * count--;
            if (max < value) max = value;
        }
        System.out.println(max);
    }
}
