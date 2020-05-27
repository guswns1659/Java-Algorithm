package topcoder;

import java.util.Arrays;

public class KiwiJuiceEasy {
    public static void main(String[] args) {
        int[] capacities = {10, 10};
        int[] bottles = {5, 8};
        int[] fromId = {0};
        int[] toId = {1};
        int[] result = thePouring(capacities, bottles, fromId, toId);
        System.out.println("result : " + Arrays.toString(result));

    }
    public static int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
        for (int index = 0; index < fromId.length; index++) {
            int sum = bottles[fromId[index]] + bottles[toId[index]];
            bottles[toId[index]] = Math.min(sum, capacities[toId[index]]);
            bottles[fromId[index]] = sum - bottles[toId[index]];
        }
        return bottles;
    }
}

