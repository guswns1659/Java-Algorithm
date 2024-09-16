package backjun.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Coupang4Test {

    public Coupang4 coupang4;

    @BeforeEach
    public void setUp() {
        Map<String, List<String>> cities = new HashMap<>();
        cities.put("a", Arrays.asList("b", "c", "d"));
        cities.put("b", Arrays.asList("a"));
        cities.put("c", Arrays.asList("a", "e"));
        cities.put("d", Arrays.asList("a"));
        cities.put("e", Arrays.asList("c"));

        Map<String, String> parent = new HashMap<>();

        this.coupang4 = new Coupang4(new ArrayList<>(), cities, 3);
    }

    @Test
    public void recursive() {
        List<String> array = new ArrayList<>();
        array.add("a");
        coupang4.recursive("a", array, coupang4.streetCount);
        System.out.println(coupang4.cityList);
        // a-b-e, a-c-e, a-d-e
    }
}
