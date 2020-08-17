package backjun;

import com.sun.org.apache.xpath.internal.axes.AttributeIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1302 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int soldCount = Integer.parseInt(br.readLine());
        List<String> books = new ArrayList<>();
        for (int loop = 0; loop < soldCount; loop++) {
            books.add(br.readLine());
        }
        System.out.println(test(books).get(0));
    }

    public static List<String> test(List<String> books) {

        Map<String, Integer> soldBooks = new LinkedHashMap<>(books.size());
        int max = 0;
        for (String book : books) {
            if (soldBooks.containsKey(book)) {
                soldBooks.put(book, soldBooks.get(book) + 1);
            } else {
                soldBooks.put(book, 1);
            }
            max = Math.max(soldBooks.get(book), max);
        }

//        long max = soldBooks.values().stream().mapToInt(i->i).max().getAsInt();

        List<String> bestSeller = new ArrayList<>();

        for (String title : soldBooks.keySet()) {
            if (soldBooks.get(title) == max) {
                bestSeller.add(title);
            }
        }
        Collections.sort(bestSeller);
        return bestSeller;
    }
}
