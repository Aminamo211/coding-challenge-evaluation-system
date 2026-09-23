public class Submission {
        private int submissionId;
        private String userOutput;
        private boolean passed;

        public Submission(int submissionId, String userOutput, boolean passed) {
            this.submissionId = submissionId;
            this.userOutput = userOutput;
            this.passed = passed;
        }

        public int getSubmissionId() {
            return submissionId;
        }

        public String getUserOutput() {
            return userOutput;
        }

        public boolean isPassed() {
            return passed;
        }

        @Override
        public String toString() {
            return "Submission ID: " + submissionId +
                    ", User Output: " + userOutput +
                    ", Passed: " + passed;
        }
    }
