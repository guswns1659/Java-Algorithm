package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 반례1) 100 1 1 -> 49나와서 men 리턴하는 걸로 변경
// 반례2) 1 100 1
// 반례3) 1 1 100
public class Intern {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        System.out.println(Arrays.toString(inputs));

        int women = Integer.parseInt(inputs[0]);
        int men = Integer.parseInt(inputs[1]);
        int interns = Integer.parseInt(inputs[2]);
        int maxCountOfTeam = women / 2;

        if (numberOfInternIsZero(interns)) {
            if (maxCountOfTeam > men) System.out.println(men);
            else System.out.println(maxCountOfTeam);
        } else {
            while (numberOfInternIsNotZero(interns)) {
                if (maxCountOfTeam == 0 || men == 0) break;
                if (maxCountOfTeam >= men) {
                    women--;
                } else {
                    men--;
                }
                interns--;
                maxCountOfTeam = women / 2;
            }
            if (maxCountOfTeam > men) System.out.println(men);
            else System.out.println(maxCountOfTeam);
        }
    }

    private static boolean numberOfInternIsNotZero(int numberOfIntern) {
        return numberOfIntern != 0;
    }

    private static boolean numberOfInternIsZero(int numberOfIntern) {
        return numberOfIntern == 0;
    }
}
