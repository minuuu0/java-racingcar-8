package racingcar.car;

import java.util.List;
import java.util.function.IntSupplier;

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

    public void moveAllWith(IntSupplier randomSupplier) {
        for (Car car : cars) {
            int randomValue = randomSupplier.getAsInt();
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