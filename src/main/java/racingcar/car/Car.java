package racingcar.car;

class Car {
    private static final int MOVE_THRESHOLD = 4;

    private final String name;
    private long position;

    public Car(String name) {
        CarValidator.validateName(name);
        this.name = name;
        this.position = 0L;
    }

    Car(String name, long position) {
        this.name = name;
        this.position = position;
    }

    String getName() {
        return name;
    }

    void moveIfPossible(int randomValue) {
        if (randomValue >= MOVE_THRESHOLD) {
            this.position++;
        }
    }

    long getPosition() {
        return position;
    }
}
