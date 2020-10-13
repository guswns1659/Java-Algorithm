package backjun.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Coupang4 {

    public List<List<String>> cityList;
    public Map<String, List<String>> cities;
    public int streetCount;
    public Map<String, String> parent = new HashMap<>();

    public Coupang4(List<List<String>> cityList, Map<String, List<String>> cities, int streetCount) {
        this.cityList = cityList;
        this.cities = cities;
        this.streetCount = streetCount;
        parent.put("a", "a");
    }

    // 사이클을 돌지 않는다는 가정으로
    public void recursive(String node, List<String> array, int streetCount) {
        // 리프노드일 조건
        if (cities.get(node).size() == 1 && cities.get(node).get(0).equals(parent.get(node))) {
            // 배열을 참조해서 넣어야지 공유참조 문제가 생기지 않는다
            List<String> copy = new ArrayList<>(array);
            cityList.add(copy);
            return;
        }

        if (array.size() == streetCount) {
            List<String> copy = new ArrayList<>(array);
            cityList.add(copy);
            return;
        }

        for (String child : cities.get(node)) {
            // 꺼낸 자식이 부모노드라면 skip
            if (parent.get(node).equals(child)) continue;
            array.add(child);
            parent.put(child, node);
            recursive(child, array, streetCount);
            // 다른 자식노드로 갈 때 마지막 노드를 하나 뺀다.
            array.remove(array.size() - 1);
        }
    }
}
