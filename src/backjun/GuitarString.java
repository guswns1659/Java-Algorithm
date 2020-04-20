package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GuitarString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int need = Integer.parseInt(inputs[0]);
        int brands = Integer.parseInt(inputs[1]);

        System.out.println("need : " + need);
        System.out.println("brands : " + brands);

        List<Integer> packages = new ArrayList<>();
        List<Integer> pieces = new ArrayList<>();

        for (int count = 0; count < brands; count++) {
            String[] Abrand = br.readLine().split(" ");
            packages.add(Integer.parseInt(Abrand[0]));
            pieces.add(Integer.parseInt(Abrand[1]));
        }

        packages.forEach(System.out::println);
        pieces.forEach(System.out::println);

    }
}
