package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Coordinate {
    public int x;
    public int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class N11650 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        String[] inputs = new String[testCase];
        for (int index = 0; index < testCase; index++) {
            inputs[index] = br.readLine();
        }
        test(inputs);
    }

    public static void test(String[] inputs) {
        List<Coordinate> coordinates = new ArrayList<>();
        for (String input : inputs) {
            String[] splitInput = input.split(" ");
            coordinates.add(new Coordinate(Integer.parseInt(splitInput[0]), Integer.parseInt(splitInput[1])));
        }

        coordinates.sort((c1, c2) -> {
            if (c1.x == c2.x) {
                return Integer.compare(c1.y, c2.y);
            }
            return Integer.compare(c1.x, c2.x);
        });

        for (Coordinate coordinate : coordinates) {
            System.out.println(coordinate.x + " " + coordinate.y);
        }

    }
}
