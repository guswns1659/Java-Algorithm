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
        List<Integer> inputToList = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Map<Integer, Integer> ports = new LinkedHashMap<>();
        inputToList.forEach(port -> ports.put(port, 0));

        System.out.println("linkedHashMap : " + ports);

        Map<Integer, Integer> beforePorts = new LinkedHashMap<>();

        int firstKey = inputToList.get(0);
        int firstValue = ports.get(firstKey);
        beforePorts.put(firstKey, ++firstValue);

        System.out.println("beforePorts : " + beforePorts);

        // 2번째 수부터
        for (int index = 1; index < numberOfPorts; index++) {
            int current = inputToList.get(index);
            long countOfLowerThanCurrent = beforePorts.keySet().stream().filter(each -> each < current).count();
            if (countOfLowerThanCurrent == 0) {
                int currentValue = ports.get(current);
                beforePorts.put(current, ++currentValue);
            } else {
                int maxBetweenLowers = beforePorts.keySet().stream().filter(each -> each < current).mapToInt(beforePorts::get).max().orElse(0);
//                int currentValue = ports.get(current);
                beforePorts.put(current, ++maxBetweenLowers);
            }
        }
        int answer = beforePorts.values().stream().mapToInt(each -> each).max().getAsInt();
        System.out.println("answer : " + answer);
    }
}
