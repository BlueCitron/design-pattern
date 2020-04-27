package problem_1;

import java.util.List;

public class DataSheetView {

    private ScoreRecord scoreRecord;
    private int viewCount;

    public DataSheetView(ScoreRecord scoreRecord, int viewCount) {
        this.scoreRecord = scoreRecord;
        this.viewCount = viewCount;
    }

    public void update() {
        List<Integer> scores = scoreRecord.getScores();
        displayScores(scores, viewCount);
    }

    private void displayScores(List<Integer> scores, int viewCount) {
        System.out.print(String.format("List of %d entries :", viewCount));
        for (int i = 0; i < viewCount && i < scores.size(); i++) {
            System.out.print(scores.get(i) + " ");
        }
        System.out.println();
    }
}
