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

    static class Node2 {
        public int priority;
        public int index;

        public Node2(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }
    }

    // 나동빈 강사 코드
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc, n, m, cnt;
        tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            Queue<Node2> q = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(); // 높은 중요도부터 처리
            cnt = 0;
            n = sc.nextInt();
            m = sc.nextInt();

            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                q.add(new Node2(x, j)); // {중요도, 인덱스} 삽입
                pq.add(-x); // 중요도 삽입  (내림차순)
            }

            while (true) {
                Node2 node = q.poll();

                // 가장 중요도가 높은 경우 출력
                if (node.priority == -pq.peek()) {
                    cnt++;
                    pq.poll();
                    if (node.index == m) {
                        System.out.println(cnt);
                        break;
                    }
                }
                else {
                    q.add(new Node2(node.priority, node.index));
                }
            }
        }
    }
}


