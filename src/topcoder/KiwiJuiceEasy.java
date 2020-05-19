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
            int fromBottle = bottles[fromId[index]];
            int fromCapacity = capacities[fromId[index]];

            int toBottle = bottles[toId[index]];
            int toCapacity = capacities[toId[index]];

            int sum = fromBottle + toBottle;
            if (sum > toCapacity) {
                bottles[fromId[index]] = sum - toCapacity;
                bottles[toId[index]] = toCapacity;
            } else {
                bottles[fromId[index]] = 0;
                bottles[toId[index]] = sum;
            }
        }
        return bottles;
    }
}

