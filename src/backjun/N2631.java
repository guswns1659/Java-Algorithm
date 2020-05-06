package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class N2631 {

    private static int lis(List<Integer> numbers) {

        int[] sequences = new int[numbers.size()];

        sequences[0] = numbers.get(0);
        int length = 1;

        for (int index = 1; index < numbers.size(); index++) {
            int current = numbers.get(index);

            if (sequences[0] > current) {
                sequences[0] = current;
            } else if (sequences[length - 1] < current) {
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int countOfChild = Integer.parseInt(br.readLine());

        List<Integer> numbers = new ArrayList<>();
        for (int count = 0; count < countOfChild; count++) {
            numbers.add(Integer.parseInt(br.readLine()));
        }
        System.out.println(countOfChild - lis(numbers));
    }
}
