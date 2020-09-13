package line;

import java.util.*;

public class Number1 {
    public static void main(String[] args) {
        Number1 number1 = new Number1();
        System.out.println(Arrays.toString(number1.solution(new int[]{11, 2, 9, 13, 24}, new int[]{9, 2, 13, 24, 11})));
    }

    public int[] solution(int[] ball, int[] order) {
        List<Integer> answer = new ArrayList<>();
        Deque<Integer> ballDeque = new LinkedList<>();
        List<Integer> orderList = new ArrayList<>();
        List<Integer> buffer = new ArrayList<>();

        for (int num : ball) {
            ballDeque.add(num);
        }

        for (int num : order) {
            orderList.add(num);
        }

        for (int index = 0; index < orderList.size(); index++) {
            // 버퍼에 있는 명령이 있는지 없는지
            if (buffer.size() != 0) {
                int flag = 0;
                do {
                    flag = 0;
                    for (int loop = 0; loop < buffer.size(); loop++) {
                        int firstBuffer = buffer.get(loop);
                        if (ballDeque.getFirst() == firstBuffer) {
                            answer.add(firstBuffer);
                            ballDeque.removeFirst();
                            buffer.remove(loop);
                            flag++; // 1
                        } else if (ballDeque.getLast() == firstBuffer) {
                            answer.add(firstBuffer);
                            ballDeque.removeLast();
                            buffer.remove(loop);
                            flag++; // 1
                        }
                    }
                } while (flag != 0);
            }
            int orderFirst = orderList.get(index);
            if (ballDeque.getFirst() == orderFirst) {
                answer.add(orderFirst);
                ballDeque.removeFirst();
//                    orderList.remove(index);
            } else if (ballDeque.getLast() == orderFirst) {
                answer.add(orderFirst);
                ballDeque.removeLast();
//                    orderList.remove(index);
            } else {
                buffer.add(orderFirst);
//                    orderList.remove(index);
            }

        }
        int[] result = new int[order.length];
        for (int index = 0; index < answer.size(); index++) {
            result[index] = answer.get(index);
        }

        return result;
    }
}
