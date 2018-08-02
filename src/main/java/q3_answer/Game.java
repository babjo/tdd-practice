package q3_answer;

class Game {

    private int[] rolls = new int[21];
    private int currentRoll = 0;

    void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    int getScore() {
        int score = 0;
        int firstRollOfFrame = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(rolls[firstRollOfFrame])) {
                score += 10 + rolls[firstRollOfFrame + 1] + rolls[firstRollOfFrame + 2];
                firstRollOfFrame += 1;
            } else if (isSpare(firstRollOfFrame)) {
                score += 10 + rolls[firstRollOfFrame + 2];
                firstRollOfFrame += 2;
            } else {
                score += rolls[firstRollOfFrame] + rolls[firstRollOfFrame + 1];
                firstRollOfFrame += 2;
            }
        }
        return score;
    }

    private boolean isSpare(int i) {
        return rolls[i] + rolls[i + 1] == 10;
    }

    private boolean isStrike(int roll) {
        return roll == 10;
    }
}
