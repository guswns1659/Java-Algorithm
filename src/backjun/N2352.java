package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class N2352 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfPorts = Integer.parseInt(br.readLine());
        List<Integer> portsList = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Map<Integer, Integer> ports = new LinkedHashMap<>();
        portsList.forEach(port -> ports.put(port, 0));

        System.out.println("linkedHashMap" + ports);

        Map<Integer, Integer> beforePorts = new LinkedHashMap<>();

//        List<Integer> decreasingPorts = new ArrayList<>(ports);


//        List<Long> possibles = new ArrayList<>();
//
//        for (Integer port : ports) {
//            long countOfBigger = decreasingPorts.stream()
//                    .filter(each -> each > port).mapToInt(e -> e).count();
//            decreasingPorts.remove(port);
//            System.out.println("decreasingPorts : " + decreasingPorts);
//            possibles.add(countOfBigger);
//        }
//
//        long answer = possibles.stream().mapToLong(e -> e).max().getAsLong();
//        System.out.println("answer : " + answer);
    }
}
