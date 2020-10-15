package programmers.graph;

import java.util.*;

public class Ranking {
    public int solution(int n, int[][] results) {

        // players 생성
        List<Player> players = new ArrayList<>(n+1);

        // players 초기화
        for (int num = 0; num < n+1; num++) {
            players.add(new Player(num));
        }

        // 경기 결과 반영
        for (int[] result : results) {
            Player p1 = players.get(result[0]);
            p1.lose.add(result[1]);
            Player p2 = players.get(result[1]);
            p2.win.add(result[0]);
        }

        // 순위 조정 로직
        for (int depth = 0; depth < n; depth++) {
            for (int i = 1; i <= n; i++) {
                Player p = players.get(i);

                // p를 이긴 선수는 p가 이긴 선수들을 모두 이긴다
                for (int winPlayerNum : p.win) {
                    Player p2 = players.get(winPlayerNum);
                    for (int p3 : p2.win) {
                        players.get(p3).lose.add(p.num);
                    }
                }

                // p한테 진 선수는 p를 이긴 선수에게 모두 진다
                for (int losePlayerNum : p.lose) {
                    // p한테 진 선수
                    Player p2 = players.get(losePlayerNum);
                    for (int p3 : p2.lose) {
                        players.get(p3).win.add(p.num);
                    }
                }
            }

        }

        int answer = 0;

        // 순위 구하기 : 이긴 사람과 진 사람의 수 합이 n-1이면 순위 확정
        for (Player p : players) {
            if (p.win.size() + p.lose.size() == n-1) {
                answer++;
            }
        }

        return answer;
    }


}

class Player {
    public int num;
    public Set<Integer> win = new HashSet<>();
    public Set<Integer> lose = new HashSet<>();

    public Player (int num) {
        this.num = num;
    }
}