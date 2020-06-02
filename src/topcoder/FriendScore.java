package topcoder;

public class FriendScore {

    public int highestScore(String[] friends) {

        int answer = 0;

        for (String friend : friends) {
            int possible = 0;

            for (int index = 0; index < friend.length(); index++) {
                if (friend.charAt(index) == 'Y') {
                    possible++;
                    int countOfY = countOfY(friends[index]);
                    if (countOfY > 1) {
                        possible += (countOfY - 1);
                    }
                }
            }
            answer = Math.max(answer, possible);
        }
        return answer;
    }

    protected int countOfY(String friend) {

        int countOfY = 0;

        for (char each : friend.toCharArray()) {
            if (each == 'Y') {
                countOfY++;
            }
        }

        return countOfY;
    }
}
