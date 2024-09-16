package kakao;

import java.util.*;

class Member {
    public String language;
    public String position;
    public String career;
    public String food;
    public int score;

    public Member(String language, String position, String career, String food, int score) {
        this.language = language;
        this.position = position;
        this.career = career;
        this.food = food;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Member{" +
                "language='" + language + '\'' +
                ", position='" + position + '\'' +
                ", career='" + career + '\'' +
                ", food='" + food + '\'' +
                ", score=" + score +
                '}';
    }
}

public class Number3 {
    public static void main(String[] args) {
        Number3 number3 = new Number3();
        System.out.println(Arrays.toString(number3.solution(new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"})));
    }

    public int[] solution(String[] info, String[] query) {
        List<Member> members = new ArrayList<>();

        for (String member : info) {
            String[] memberFields = member.split(" ");
            members.add(new Member(memberFields[0], memberFields[1], memberFields[2], memberFields[3], Integer.parseInt(memberFields[4])));
        }

        List<String[]> queries = new ArrayList<>();

        for (String queryOne : query) {
            String[] splitQuery = queryOne.replaceAll("and ", "").split(" ");
            queries.add(splitQuery);
        }

        // 이진탐색으로 해당 점수의 인덱스 찾기
        List<Member> newMember1;
        List<Member> newMember2;
        List<Member> newMember3;
        List<Member> newMember4;
        List<Member> newMember5;
        int index = 0;
        int[] answer = new int[queries.size()];

        for (String[] queryOne : queries) {
            newMember1 = new ArrayList<>();
            newMember2 = new ArrayList<>();
            newMember3 = new ArrayList<>();
            newMember4 = new ArrayList<>();
            newMember5 = new ArrayList<>();
            for (Member member : members) {
                // 쿼리 점수 이상인 멤버들
                if (member.score >= Integer.parseInt(queryOne[4])) {
                    newMember1.add(member);
                }
            }

            if (!queryOne[0].equals("-")) {
                // 쿼리 언어인 멤버들
                for (Member member : newMember1) {
                    if (member.language.equals(queryOne[0])) {
                        newMember2.add(member);
                    }
                }
            } else {
                newMember2 = newMember1;
            }

            if (!queryOne[1].equals("-")) {
                // 쿼리 직군 멤버들
                for (Member member : newMember2) {
                    if (member.position.equals(queryOne[1])) {
                        newMember3.add(member);
                    }
                }
            } else {
                newMember3 = newMember2;
            }

            if (!queryOne[2].equals("-")) {
                // 쿼리 경력 멤버들
                for (Member member : newMember3) {
                    if (member.career.equals(queryOne[2])) {
                        newMember4.add(member);
                    }
                }
            } else {
                newMember4 = newMember3;
            }

            if (!queryOne[3].equals("-")) {
                // 쿼리 음식 멤버들
                for (Member member : newMember4) {
                    if (member.food.equals(queryOne[3])) {
                        newMember5.add(member);
                    }
                }
            } else {
                newMember5 = newMember4;
            }
            answer[index] = newMember5.size();
            index++;
        }

        return answer;
    }
}
