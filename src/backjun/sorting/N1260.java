package backjun.sorting;

import java.util.*;
import java.io.*;

public class N1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int nodeCount = Integer.parseInt(inputs[0]);
        int edgeCount = Integer.parseInt(inputs[1]);
        int startNode = Integer.parseInt(inputs[2]);

        int[][] graph = new int[nodeCount][nodeCount];

        for (int loop = 0; loop < edgeCount; loop++) {
            String[] relations = br.readLine().split(" ");
            int x = Integer.parseInt(relations[0]) - 1;
            int y = Integer.parseInt(relations[1]) - 1;

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        for (int node : dfs(graph, startNode)) {
            System.out.print(node + " ");
        }
        System.out.println();
        for (int node : bfs(graph, startNode)) {
            System.out.print(node + " ");
        }
    }

    public static List<Integer> dfs(int[][] graph, int startNode) {
        List<Integer> visited = new ArrayList<>();
        List<Integer> needVisit = new ArrayList<>();

        needVisit.add(startNode);

        while (needVisit.size() != 0) {
            int popNode = needVisit.remove(needVisit.size() - 1);
            if (!visited.contains(popNode)) {
                visited.add(popNode);
                for (int index = graph[popNode-1].length - 1; index > -1; index--) {
                    if (index == popNode - 1) {
                        continue;
                    }
                    if (graph[popNode-1][index] == 1) {
                        needVisit.add(index + 1);
                    }
                }
            }
        }
        return visited;
    }

    public static List<Integer> bfs(int[][] graph, int startNode) {
        List<Integer> visited = new ArrayList<>();
        List<Integer> needVisit = new ArrayList<>();

        needVisit.add(startNode);

        while (needVisit.size() != 0) {
            int popNode = needVisit.remove(0);
            if (!visited.contains(popNode)) {
                visited.add(popNode);
                for (int index = 0; index < graph[popNode-1].length; index++) {
                    if (index == popNode - 1) {
                        continue;
                    }
                    if (graph[popNode-1][index] == 1) {
                        needVisit.add(index + 1);
                    }
                }
            }
        }
        return visited;
    }
}