import java.util.ArrayList;

public class CodingChallenge {
    private int challengeId;
    private String title;
    private String description;
    private String difficulty;
    private ArrayList<TestCase> testCases;

    public CodingChallenge(int challengeId, String title, String description, String difficulty) {
        this.challengeId = challengeId;
        this.title = title;
        this.description = description;
        this.difficulty = difficulty;
        this.testCases = new ArrayList<>();
    }

    public int getChallengeId() {
        return challengeId;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<TestCase> getTestCases() {
        return testCases;
    }

    public void addTestCase(TestCase testCase) {
        testCases.add(testCase);
    }

    public void displayChallenge() {
        System.out.println("ID: " + challengeId);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Difficulty: " + difficulty);
        System.out.println("Test Cases:");
        for (TestCase testCase : testCases) {
            System.out.println(" - " + testCase);
        }
    }
}