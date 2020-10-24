package nhn;

import java.util.Arrays;

public class Number2 {

    public static void main(String[] args) {
        solution(2, 6, new int[][]{{6,2,11,0,3,5}, {6,3,0,9,0,5}});
    }

    private static void solution(int day, int width, int[][] blocks) {

        // 누적 벽돌 초기화
        int[] overallBlocks = new int[width];
        for (int index = 0; index < width; index++) {
            overallBlocks[index] = 0;
        }

        int answer = 0;

        // 공사기간
        for (int index = 0; index < day; index++) {
            // 당일 벽돌을 누적 벽돌에 더하기
            int[] block = blocks[index];
            for (int loop = 0; loop < width; loop++) {
                overallBlocks[loop] += block[loop];
            }

            // 최댓값 찾기
            int max = 0;
            int maxIndex = 0;
            for (int i = 0; i < width; i++) {
                if (max < overallBlocks[i]) {
                    max = overallBlocks[i];
                    maxIndex = i;
                }
            }

            // 왼쪽 끝에 있는 벽돌이라면
            if (maxIndex == 0) {
                // 다음 최댓값 찾기
                int nextMax = 0;
                int nextMaxIndex = 0;
                // 두번째로 큰 벽돌이 마지막인덱스일 때까지 순회
                while (nextMaxIndex < width) {
                    for (int j = nextMaxIndex + 1; j < width; j++) {
                        if (nextMax < overallBlocks[j]) {
                            nextMax = overallBlocks[j];
                            nextMaxIndex = j;
                        }
                    }

                    // 1~ 두번째로 큰 벽돌까지 시멘트칠한다
                    for (int x = 1; x < nextMaxIndex; x++) {
                        answer += nextMax - overallBlocks[x];
                    }
                }

            } else if (maxIndex == width - 1) {
                int nextMax = 0;
                int nextMaxIndex = width - 1;
                while (nextMaxIndex > -1) {
                    for (int j = nextMaxIndex - 1; j > -1; j--) {
                        if (nextMax < overallBlocks[j]) {
                            nextMax = overallBlocks[j];
                            nextMaxIndex = j;
                        }
                    }

                    // 마지막 2번째 벽돌에서 두번째로 큰 벽돌까지 더한다
                    for (int x = width - 2; x > nextMaxIndex; x--) {
                        answer += nextMax - overallBlocks[x];
                    }
                }

                // 중간에 있는 큰 벽돌 있는 경우
            } else {
                // 왼쪽 벽돌 중 가장 큰애를 뽑는다
                int nextMax = 0;
                int nextMaxIndex = 0;
                for (int i = 0; i < maxIndex; i++) {
                    if (nextMax < overallBlocks[i]) {
                        nextMax = overallBlocks[i];
                        nextMaxIndex = i;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
