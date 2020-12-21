public class TennisGame {
    public static final String LOVE = "Love";
    public static final String DASH = "-";
    public static final String ALL = "All";
    public static final String FIFTEEN = "Fifteen";
    public static final String THIRTY = "Thirty";
    public static final String FORTY = "Forty";
    public static final String DEUCE = "Deuce";
    public static final String ADVANTAGE_FIRST_PLAYER = "Advantage firstPlayer";
    public static final String ADVANTAGE_SECOND_PLAYER = "Advantage secondPlayer";
    public static final String WIN_FOR_FIRST_PLAYER = "Win for firstPlayer";
    public static final String WIN_FOR_SECOND_PLAYER = "Win for secondPlayer";

    public static String getScore(String firstPlayerName, String secondPlayerName, int firstPlayerScore, int secondPlayerScore) {
        String score = "";
        int tempScore = 0;
        if (firstPlayerScore == secondPlayerScore) {
            score = getScoreInWord(firstPlayerScore);
        } else if (firstPlayerScore >= 4 || secondPlayerScore >= 4) {
            score = getScoreInWord(firstPlayerScore, secondPlayerScore);
        } else {
            score = getScoreInWord(firstPlayerScore, secondPlayerScore, score);
        }
        return score;
    }

    private static String getScoreInWord(int firstPlayerScore, int secondPlayerScore, String score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = firstPlayerScore;
            else {
                score += DASH;
                tempScore = secondPlayerScore;
            }
            switch (tempScore) {
                case 0:
                    score += LOVE;
                    break;
                case 1:
                    score += FIFTEEN;
                    break;
                case 2:
                    score += THIRTY;
                    break;
                case 3:
                    score += FORTY;
                    break;
            }
        }
        return score;
    }

    private static String getScoreInWord(int firstPlayerScore, int secondPlayerScore) {
        String score;
        int minusResult = firstPlayerScore - secondPlayerScore;
        if (minusResult == 1) score = ADVANTAGE_FIRST_PLAYER;
        else if (minusResult == -1) score = ADVANTAGE_SECOND_PLAYER;
        else if (minusResult >= 2) score = WIN_FOR_FIRST_PLAYER;
        else score = WIN_FOR_SECOND_PLAYER;
        return score;
    }

    private static String getScoreInWord(int firstPlayerScore) {
        String score;
        switch (firstPlayerScore) {
            case 0:
                score = LOVE + DASH + ALL;
                break;
            case 1:
                score = FIFTEEN + DASH + ALL;
                break;
            case 2:
                score = THIRTY + DASH + ALL;
                break;
            case 3:
                score = FORTY + DASH + ALL;
                break;
            default:
                score = DEUCE;
                break;

        }
        return score;
    }
}
