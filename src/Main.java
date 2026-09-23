import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<CodingChallenge> challenges = new ArrayList<>();
    Evaluator evaluator = new Evaluator();
    int challengeCounter = 1;

    while (true) {
      System.out.println("\n=== Coding Challenge Evaluation System ===");
      System.out.println("1. Add Coding Challenge");
      System.out.println("2. View Challenges");
      System.out.println("3. Add Test Case to Challenge");
      System.out.println("4. Submit Output for Evaluation");
      System.out.println("5. Exit");
      System.out.print("Choose an option: ");

      int choice = scanner.nextInt();
      scanner.nextLine();

      if (choice == 1) {
        System.out.print("Enter challenge title: ");
        String title = scanner.nextLine();

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        System.out.print("Enter difficulty: ");
        String difficulty = scanner.nextLine();

        CodingChallenge challenge = new CodingChallenge(challengeCounter++, title, description, difficulty);
        challenges.add(challenge);
        System.out.println("Challenge added successfully.");

      } else if (choice == 2) {
        if (challenges.isEmpty()) {
          System.out.println("No challenges available.");
        } else {
          for (CodingChallenge challenge : challenges) {
            challenge.displayChallenge();
            System.out.println();
          }
        }

      } else if (choice == 3) {
        System.out.print("Enter challenge ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        CodingChallenge selected = null;
        for (CodingChallenge challenge : challenges) {
          if (challenge.getChallengeId() == id) {
            selected = challenge;
            break;
          }
        }

        if (selected != null) {
          System.out.print("Enter test case input: ");
          String input = scanner.nextLine();

          System.out.print("Enter expected output: ");
          String expectedOutput = scanner.nextLine();

          selected.addTestCase(new TestCase(input, expectedOutput));
          System.out.println("Test case added.");
        } else {
          System.out.println("Challenge not found.");
        }

      } else if (choice == 4) {
        System.out.print("Enter challenge ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        CodingChallenge selected = null;
        for (CodingChallenge challenge : challenges) {
          if (challenge.getChallengeId() == id) {
            selected = challenge;
            break;
          }
        }

        if (selected != null && !selected.getTestCases().isEmpty()) {
          int passedCount = 0;
          int total = selected.getTestCases().size();

          for (TestCase testCase : selected.getTestCases()) {

            System.out.println("\nTest Input: " + testCase.getInput());
            System.out.print("Enter your output: ");
            String userOutput = scanner.nextLine();

            boolean passed = evaluator.evaluate(testCase.getExpectedOutput(), userOutput);

            System.out.println(evaluator.generateFeedback(testCase.getExpectedOutput(), userOutput));

            if (passed) {
              passedCount++;
            }
          }

          System.out.println("\nFinal Result: Passed " + passedCount + " out of " + total + " test cases.");
        } else {
          System.out.println("Challenge not found or no test cases available.");
        }

      } else if (choice == 5) {
        System.out.println("Exiting program.");
        break;

      } else {
        System.out.println("Invalid choice.");
      }
    }

    scanner.close();
  }
}