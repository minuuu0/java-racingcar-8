package racingcar;

class Car {
    private static final int MOVE_THRESHOLD = 4;

    final String name;
    long position;

    public Car(String name) {
        CarValidator.validateName(name);
        this.name = name;
        this.position = 0L;
    }

    public String getName() {
        return name;
    }

    public void moveIfPossible(int randomValue) {
        if (randomValue >= MOVE_THRESHOLD) {
            this.position++;
        }
    }

    public long getPosition() {
        return position;
    }
}
