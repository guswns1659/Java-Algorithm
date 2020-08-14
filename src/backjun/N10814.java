package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Member {
    public int age;
    public String name;

    public Member(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

public class N10814 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        List<Member> members = new ArrayList<>();

        for (int index = 0; index < testCase; index++) {
            String[] member = br.readLine().split(" ");
            members.add(new Member(Integer.parseInt(member[0]), member[1]));
        }

        members.sort(Comparator.comparing(member -> member.age));

        for (Member member : members) {
            System.out.println(member.age + " " + member.name);
        }
    }
}
