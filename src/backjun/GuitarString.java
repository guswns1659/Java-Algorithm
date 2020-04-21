package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GuitarString {

    private static final int A_PIECE_OF_PACKAGE = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int need = Integer.parseInt(inputs[0]);
        int brands = Integer.parseInt(inputs[1]);

        System.out.println("need : " + need);
        System.out.println("brands : " + brands);

        List<Integer> packages = new ArrayList<>();
        List<Integer> pieces = new ArrayList<>();

        for (int count = 0; count < brands; count++) {
            String[] Abrand = br.readLine().split(" ");
            packages.add(Integer.parseInt(Abrand[0]));
            pieces.add(Integer.parseInt(Abrand[1]));
        }

        int minPackage = packages.stream().mapToInt(price -> price).min().getAsInt();
        int minPiece = pieces.stream().mapToInt(price -> price).min().getAsInt();

        List<Integer> candidates = new ArrayList<>();

        int quotient = need / A_PIECE_OF_PACKAGE;
        int remainder = need % A_PIECE_OF_PACKAGE;

        System.out.println("quotient:" + quotient);
        System.out.println("remainder:" + remainder);

        // 1. 패키지 가격 중 최솟값으로 가격을 구한다.
        candidates.add(calculateWithMinPackages(quotient, remainder, minPackage));

        // 2. 낱개 가격 중 최솟값으로 가격을 구한다.
        candidates.add(need * minPiece);

        // 3. 두 개를 섞어서 가격을 구한다.
        candidates.add(calculateWithBoth(minPackage, minPiece, quotient, remainder));

        int answer = candidates.stream().mapToInt(c -> c).min().getAsInt();
        System.out.println(answer);
    }

    private static int calculateWithBoth(int minPackage, int minPiece, int quotient, int remainder) {
        int minPrice = 0;
        minPrice += (quotient * minPackage);
        minPrice += (remainder * minPiece);
        return minPrice;
    }

    private static int calculateWithMinPackages(int quotient, int remainder, int minPackage) {
        if (remainder == 0) {
            return quotient * minPackage;
        } else {
            return (quotient + 1) * minPackage;
        }
    }
}
