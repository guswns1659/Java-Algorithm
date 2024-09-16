package backjun.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    public int index;
    public int priority;

    public Node(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}

public class N1966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int loop = 0; loop < testCase; loop++) {
            List<Integer> prioritiesList = new ArrayList<>();
            Queue<Node> nodeQueue = new LinkedList<>();
            String[] inputs = br.readLine().split(" ");
            int paperCount = Integer.parseInt(inputs[0]);
            int findingIndex = Integer.parseInt(inputs[1]);

            // 우선순위 리스트 받음
            String[] priorities = br.readLine().split(" ");

            // 인덱스, 우선순위 기반 Node 만들기
            for (int index = 0; index < paperCount; index++) {
                int priority = Integer.parseInt(priorities[index]);
                Node node = new Node(index, priority);
                nodeQueue.offer(node);
                prioritiesList.add(priority);
            }
            // 우선순위를 내림차순으로 초기화하기
            prioritiesList.sort(Collections.reverseOrder());
            System.out.println(solution(nodeQueue, prioritiesList, findingIndex));
        }
    }

    private static int solution(Queue<Node> nodeQueue, List<Integer> prioritiesList, int findingIndex) {
        int order = 0;
        while (true) {
            Node pollNode = nodeQueue.poll();

            // queue에서 꺼낸 노드가 찾던 노드일 때
            if (pollNode.index == findingIndex) {
                // 찾던 노드가 최우선순위일 때
                if (pollNode.priority == prioritiesList.get(0)) {
                    return ++order;
                }
            } else {
                if (pollNode.priority == prioritiesList.get(0)) {
                    order++;
                    // 나온 우선순위를 List에서 지운다
                    prioritiesList.remove(0);
                    continue;
                }
            }
            nodeQueue.offer(pollNode);
        }
    }
}
