package racingcar;

public class Car {
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

    public void move() {
        this.position++;
    }

    public long getPosition() {
        return position;
    }
}
