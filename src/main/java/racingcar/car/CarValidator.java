package racingcar.car;

class CarValidator {
    private static final String VALID_NAME_PATTERN = "[a-zA-Z]+";
    private static final int MAX_NAME_LENGTH = 5;

    private CarValidator() {
    }

    public static void validateName(String name) {
        validateNotBlank(name);
        validatePattern(name);
        validateLength(name);
    }

    private static void validateNotBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validatePattern(String name) {
        if (!name.matches(VALID_NAME_PATTERN)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}