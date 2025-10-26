package racingcar;

import java.util.List;

class Cars {
    private final List<Car> cars;

    Cars(List<String> carNames) {
        this.cars = carNames.stream()
                .map(Car::new)
                .toList();
    }

    int size() {
        return cars.size();
    }

    List<Car> getCars() {
        return cars;
    }

    List<String> getWinners() {
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