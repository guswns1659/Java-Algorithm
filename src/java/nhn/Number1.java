package nhn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Number1 {

    public static void main(String[] args) {
        solution(6, 2, new char[]{'B', 'C'}, 2, new int[]{3, -2});
        System.out.println();
        solution(17, 5, new char[]{'B', 'D', 'I', 'M', 'P'}, 11, new int[]{3, -4, 5, 6, -7, -8, 10, -12, -15, -20, 23});
    }

    private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame){
        // 이전 술래 인덱스, 현재 술래 인덱스
        List<Character> persons = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        char a = 'A';
        // persons, map 초기화
        for (int num = 1; num < numOfAllPlayers; num++) {
            persons.add((char) (a + num));
            map.put((char) (a + num), 0);
        }
        // A는 무조건 1을 추가
        map.put(a, 1);

        // 술래잡기 시작
        int priorIndex = 0;
        Character priorSulrae = 'A';
        Character sulrae = ' ';
        for (int move : numOfMovesPerGame) {
            int currentIndex = priorIndex + move;
            if (currentIndex < 0) {
                currentIndex = persons.size() + currentIndex;
            } else if (currentIndex >= persons.size()) {
                currentIndex = currentIndex - persons.size();
            }
            boolean flag = true;

            sulrae = persons.get(currentIndex);

            // 술래가 잡히는지 아닌지 확인
            for (Character quick : namesOfQuickPlayers) {
                if (sulrae == quick) {
                    flag = false;
                }
            }

            // 술래에 대한 처리
            if (flag) {
                Character remove = persons.remove(currentIndex);
                persons.add(currentIndex, priorSulrae);
                priorIndex = currentIndex;
                map.put(sulrae, map.get(sulrae) + 1);
                priorSulrae = remove;
            } else {
                priorIndex = currentIndex;
                map.put(priorSulrae, map.get(priorSulrae) + 1);
                sulrae = priorSulrae;
            }
        }

        // 출력
        for (char person : persons) {
            System.out.println(person + " " + map.get(person));
        }
        System.out.println(sulrae + " " + map.get(sulrae));
    }
}
