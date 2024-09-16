package backjun.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class Person {
    public int weight;
    public int height;

    public Person(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }
}

public class N7568 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Person, Integer> map = new LinkedHashMap<>();
        List<Person> people = new ArrayList<>();
        int peopleCount = Integer.parseInt(br.readLine());

        // map 초기화하기
        for (int loop = 0; loop < peopleCount; loop++) {
            String[] physicalInfo = br.readLine().split(" ");
            Person person = new Person(Integer.parseInt(physicalInfo[0]), Integer.parseInt(physicalInfo[1]));
            people.add(person);
            map.put(person, 1);
        }

        // 사람 간 키와 몸무게를 비교하는 작업
        for (int index1 = 0; index1 < people.size(); index1++) {
            for (int index2 = 0; index2 < people.size(); index2++) {
                if (index1 >= index2) continue;
                Person person1 = people.get(index1);
                Person person2 = people.get(index2);
                // person1가 2보다 덩치가 클 때
                if (person1.weight > person2.weight && person1.height > person2.height) {
                    map.merge(person2, 1, Integer::sum);
                } else if (person1.weight < person2.weight && person1.height < person2.height) {
                    map.merge(person1, 1, Integer::sum);
                }
            }
        }

        // 출력
        for (int rank : map.values()) {
            System.out.print(rank + " ");
        }
    }
}
