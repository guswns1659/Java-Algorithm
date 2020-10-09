package coupang;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class M {
    public int id;
    public LocalDateTime expect; // 예정 운영 완료
    public boolean working; // 일하는 중인지 아닌지
    public int count;

    public M(int id, LocalDateTime expect, boolean working, int count) {
        this.id = id;
        this.expect = expect;
        this.working = working;
        this.count = count;
    }

    public void addExpected(C c) {
        if (this.expect == null) {
            this.expect = c.enter.plusMinutes(c.time);
        } else {
            this.expect = this.expect.plusMinutes(c.time);
        }
        if (this.expect.getMonth().getValue() == 2 && this.expect.isAfter(LocalDateTime.of(2020,2,29,0,0,0))) {
            this.expect = LocalDateTime.of(2020, 3, 1, this.expect.getHour(), this.expect.getMinute(), this.expect.getSecond());
        }
    }
}

class C {
    public LocalDateTime enter; // 방문날짜
    public int time; // 소요시간

    public C(LocalDateTime enter, int time) {
        this.enter = enter;
        this.time = time;
    }
}

public class Number2 {
    public static void main(String[] args) {
        Number2 number2 = new Number2();
        System.out.println(number2.solution(3, new String[]{"10/01 23:20:25 30", "10/01 23:25:50 26", "10/01 23:31:00 05", "10/01 23:33:17 24", "10/01 23:50:25 13", "10/01 23:55:45 20", "10/01 23:59:39 03", "10/02 00:10:00 10"}));
        System.out.println(number2.solution(2, new String[]{"02/28 23:59:00 03", "03/01 00:00:00 02", "03/01 00:05:00 01"})); // 2
    }

    private int solution(int n, String[] customers) {

        List<M> ms = new ArrayList<>();
        List<C> cs = new ArrayList<>();

        // 로봇 초기화
        for (int i = 1; i < n + 1; i++) {
            M m = new M(i, null, false, 0);
            ms.add(m);
        }

        for (String customer : customers) {
            String[] split = customer.split(" ");
            String[] date = split[0].split("/");
            String[] localtime = split[1].split(":");
            C c = new C(LocalDateTime.of(2020, Integer.parseInt(date[0]), Integer.parseInt(date[1]),
                    Integer.parseInt(localtime[0]), Integer.parseInt(localtime[1]), Integer.parseInt(localtime[2])), Integer.parseInt(split[2]));
            cs.add(c);
        }

        for (C c : cs) {
            // 고객 도착 시간보다 작은 expect면 working false로 변경
            // 일을 하고 있다고 표시되어 있지만 사실 끝난 애들은 false로 바꿔줘야함.
            for (M m999 : ms) {
                if (m999.working) {
                    if (m999.expect.isBefore(c.enter)) {
                        m999.working = false;
                    }
                }
            }

            // working = false인 기계
            List<M> ms2 = ms.stream().filter(m -> !m.working).collect(Collectors.toList());
            boolean breakCount = false;
            // false인 기계가 있다면
            if (ms2.size() > 0) {
                for (M m888 : ms2) {
                    if (m888.expect == null) {
                        breakCount = true;
                        break;
                    }
                }
                if (breakCount) {
                    M m7 = ms2.get(0);
                    m7.addExpected(c);
                    m7.working = true;
                    m7.count++;
                } else  {
                    sort(c, (List<M>) ms2);
                }
            } else {
                // 운영시간이 가장 빠른 순서로 정렬
                sort(c, (List<M>) ms);
            }
        }

        ms.sort((o1, o2) -> o2.count - o1.count);

        return ms.get(0).count;
    }

    private void sort(C c, List<M> ms2) {
        ms2.sort((o1, o2) -> {
            if (o1.expect.equals(o2.expect)) {
                return Integer.compare(o1.id, o2.id);
            }
            return o1.expect.compareTo(o2.expect);
        });
        M m7 = ms2.get(0);
        m7.addExpected(c);
        m7.working = true;
        m7.count++;
    }
}
