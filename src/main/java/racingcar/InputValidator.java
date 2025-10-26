package racingcar;

public class InputValidator {

    private InputValidator() {
    }

    public static int parseAndValidateAttemptCount(String input) {
        int attemptCount = parseToInt(input);
        validatePositive(attemptCount);
        return attemptCount;
    }

    private static int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void validatePositive(int attemptCount) {
        if (attemptCount <= 0) {
            throw new IllegalArgumentException();
        }
    }
}