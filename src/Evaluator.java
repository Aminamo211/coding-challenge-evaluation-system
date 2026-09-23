public class Evaluator {
    public boolean evaluate(String expectedOutput, String userOutput) {
        return expectedOutput.trim().equals(userOutput.trim());
    }

    public String generateFeedback(String expectedOutput, String userOutput) {
        if (evaluate(expectedOutput, userOutput)) {
            return "Correct output. Test case passed.";
        } else {
            return "Incorrect output. Expected: " + expectedOutput + ", but got: " + userOutput;
        }
    }
}


