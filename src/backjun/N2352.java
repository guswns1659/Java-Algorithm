package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class N2352 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfPorts = Integer.parseInt(br.readLine());
        List<Integer> ports = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> decreasingPorts = new ArrayList<>(ports);

        System.out.println("numberOfPorts : " + numberOfPorts);

        List<Long> possibles = new ArrayList<>();

        for (Integer port : ports) {
            long countOfBigger = decreasingPorts.stream().filter(each -> each > port).mapToInt(e -> e).count();
            decreasingPorts.remove(port);
            possibles.add(countOfBigger);
        }

        long answer = possibles.stream().mapToLong(e -> e).max().getAsLong();
        System.out.println("answer : " + answer);
    }
}
