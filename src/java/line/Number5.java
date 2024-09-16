package line;

import java.util.*;

public class Number5 {

    int playerSum = 0;
    int dealerSum = 0;
    int dearOpenCard = 0;
    int playerPoint = 0;

    List<Integer> player = new ArrayList<>();
    List<Integer> dealer = new ArrayList<>();
    Deque<Integer> cardQueue = new LinkedList<>();

    public static void main(String[] args) {
        Number5 number5 = new Number5();
//        System.out.println(number5.solution(new int[]{12, 7, 11, 6, 2, 12}));
        System.out.println(number5.solution(new int[]{1, 4, 10, 6, 9, 1, 8, 13}));
        System.out.println(number5.solution(new int[]{10, 13, 10, 1, 2, 3, 4, 5, 6, 2}));
        System.out.println(number5.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3}));
    }

    public int solution(int[] cards) {
        cardQueue.clear();
        for (int card : cards) {
            cardQueue.add(card);
        }

        /*
         * 카드 없는 경우는 -100을 리턴하고 게임을 종료한다.
         * 카드를 뺄 때마다 cardQueue에 있는지 없는지 판단한다. 없다면 return -100
         * -1이 아니라면 playPoint에 결과값을 더한다.
         */
        while (!cardQueue.isEmpty()) {
            int result = blackJack();
            if (result == -100) {
                break;
            }
            playerPoint += result;
        }
        return playerPoint;


    }

    public int blackJack() {
        playerSum = 0;
        dealerSum = 0;
        dearOpenCard = 0;
        playerPoint = 0;

        player = new ArrayList<>();
        dealer = new ArrayList<>();
        // 처음 4개 카드 나누기
        for (int index = 1; index < 5; index++) {
            if (index % 2 == 1) {
                if (!cardIsExist()) return -100;
                int card = cardQueue.pollFirst();
                player.add(card);
                // 카드가 1인 경우와 10인 경우를 나누는 로직
                playerSum = cardSum(playerSum, card);
            } else {
                if (!cardIsExist()) return -100;
                int card = cardQueue.pollFirst();
                dealer.add(card);
                dealerSum = cardSum(dealerSum, card);
            }
        }

        dearOpenCard = dealer.get(dealer.size() - 1);

//        // 5.1 플레이어가 21이라서 딜러 카드 합이 17이상 될 때 까지 받는다.
        if (playerSum == 21) {
            if (playerSum == dealerSum) return 0;
                // 플레이어가 블랙잭으로 승리한 경우
            else return 3;
//            while (dealerSum < 17) {
//                if (!cardIsExist()) return -100;
//                int card = cardQueue.pollFirst();
//                dealer.add(card);
//                dealerSum = cardSum(dealerSum, card);
//            }
//            if (dealerSum > 21) return 2;
//            else {
//                // 둘 다 21인 경우
//                if (playerSum == dealerSum) return 0;
//                // 플레이어가 블랙잭으로 승리한 경우
//                else return 3;
//            }
        }

        // 5.2~3
        while (playerSum < 21) {
            // 보이는 카드 전략
            // 1과 7인 경우 플레이어 합이 17이상 될 때 까지 받는다.
            if (dearOpenCard == 1 || dearOpenCard == 7) {
                while (playerSum < 17) {
                    if (!cardIsExist()) return -100;
                    int card = cardQueue.pollFirst();
                    player.add(card);
                    playerSum = cardSum(playerSum, card);
                }
                if (playerSum > 21) return 0;
                while (dealerSum < 17) {
                    if (!cardIsExist()) return -100;
                    int card = cardQueue.pollFirst();
                    dealer.add(card);
                    dealerSum = cardSum(dealerSum, card);
                }
                if (dealerSum > 21) return 2;
                else {
                    // 둘 다 21인 경우
                    if (playerSum == dealerSum) return 0;
                        // 플레이어가 블랙잭으로 승리한 경우
                    else return 3;
                }
            }

            // 4, 5, 6인 경우 플레이어는 카드를 받지 않는다.
            if (dearOpenCard >= 4 && dearOpenCard <= 6) break;

            // 2,3인 경우 플레이어는 카드의 합이 12이상이 될 때까지 받는다.
            while (playerSum < 12) {
                if (!cardIsExist()) return -100;
                int card = cardQueue.pollFirst();
                player.add(card);
                playerSum = cardSum(playerSum, card);
            }
            if (playerSum > 21) return 0;
            while (dealerSum < 17) {
                if (!cardIsExist()) return -100;
                int card = cardQueue.pollFirst();
                dealer.add(card);
                dealerSum = cardSum(dealerSum, card);
            }
            if (dealerSum > 21) return 2;
            else {
                // 둘 다 21인 경우
                if (playerSum == dealerSum) return 0;
                    // 플레이어가 블랙잭으로 승리한 경우
                else return 3;
            }
        }

        while (dealerSum < 17) {
            if (!cardIsExist()) return -100;
            int card = cardQueue.pollFirst();
            dealer.add(card);
            dealerSum = cardSum(dealerSum, card);
        }
        if (dealerSum > 21) return 2;
        else {
            // 둘 다 21인 경우
            if (playerSum == dealerSum) return 0;
                // 플레이어가 블랙잭으로 승리한 경우
            else return -2;
        }
    }

    public int cardSum(int cardSum, int card) {
        if (card == 1) {
            int temperSum = cardSum + 11;
            if (temperSum <= 21) cardSum = temperSum;
            else cardSum += 1;
        } else if (card >= 10) {
            cardSum += 10;
        } else {
            cardSum += card;
        }
        return cardSum;
    }

    public boolean cardIsExist() {
        return !cardQueue.isEmpty();
    }
}
