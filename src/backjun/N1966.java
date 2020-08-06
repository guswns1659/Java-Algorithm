package backjun;

import java.util.*;

public class N1966 {

    static class Node {
        private int key;
        private int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }

    public static int test(int[] paperNumberAndFindingPaperIndex, int[] priorities) {

        int paperNumber = paperNumberAndFindingPaperIndex[0];
        int findingPaperIndex = paperNumberAndFindingPaperIndex[1];

        List<Node> nodes = new ArrayList<>();

        for (int index = 0; index < paperNumber; index++) {
            nodes.add(new Node(priorities[index], index));
        }

        int count = 0;
        while (true) {
            int max = nodes.stream().mapToInt(Node::getKey).max().getAsInt();
            if (nodes.get(0).getKey() == max) {
                count++;
                if (nodes.get(0).getValue() == findingPaperIndex) {
                    return count;
                } else {
                    nodes.remove(0);
                }
            } else {
                nodes.add(nodes.remove(0));
            }
        }
    }
}
