package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class N2532 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfAnimals = Integer.parseInt(br.readLine());
        List<Integer> distances = new ArrayList<>();

        for (int count = 0; count < numberOfAnimals; count++) {
            List<Integer> eachCondition = Stream.of(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            int distance = eachCondition.get(2) - eachCondition.get(1);
            distances.add(distance);
        }
        Collections.sort(distances);
//        System.out.println(distances);

        System.out.println(lis(distances));
    }

    public static int lis(List<Integer> distances) {
        int[] sequences = new int[distances.size()];
        sequences[0] = distances.get(0);
        int length = 1;

        for (int index = 1; index < distances.size(); index++) {
            int current = distances.get(index);

            if (current < sequences[0]) {
                sequences[0] = current;
            } else if (current > sequences[length - 1]) {
                sequences[length] = current;
                length++;
            } else {
                int location = Arrays.binarySearch(sequences, 0, length, current);
                location = location < 0 ? -location - 1 : location;
                sequences[location] = current;
            }
        }
        return length;
    }
}
