package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class N2352 {
    static int lis(List<Integer> ports) {
        int[] sequences = new int[ports.size()];
        sequences[0] = ports.get(0);
        int length = 1;

        for (int index = 1; index < ports.size(); index++) {
            int currentPort = ports.get(index);
            if (sequences[0] > currentPort) {
                sequences[0] = currentPort;
            } else if (currentPort > sequences[length - 1]) {
                sequences[length] = currentPort;
                length++;
            } else {
                int location = Arrays.binarySearch(sequences, 0, length, currentPort);
                location = location < 0 ? -location - 1 : location;
                sequences[location] = currentPort;
            }
        }

        return length;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int countOfPorts = Integer.parseInt(br.readLine());
        List<Integer> ports = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println(lis(ports));
    }
}

