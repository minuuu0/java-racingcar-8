package racingcar.car;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = carNames.stream()
                .map(Car::new)
                .toList();
    }

    // only TEST
    Cars(Car... cars) {
        this.cars = List.of(cars);
    }

    // only TEST
    int size() {
        return cars.size();
    }

    public void moveAll(int randomValue) {
        for (Car car : cars) {
            car.moveIfPossible(randomValue);
        }
    }

    public List<String> getCarNames() {
        return cars.stream()
                .map(Car::getName)
                .toList();
    }

    public List<Long> getCarPositions() {
        return cars.stream()
                .map(Car::getPosition)
                .toList();
    }

    public List<String> getWinners() {
        long maxPosition = findMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    private long findMaxPosition() {
        return cars.stream()
                .mapToLong(Car::getPosition)
                .max()
                .orElse(0L);
    }
}