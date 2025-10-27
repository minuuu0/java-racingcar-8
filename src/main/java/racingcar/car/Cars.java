package racingcar.car;

import racingcar.RandomNumberGenerator;
import java.util.List;
import java.util.function.IntSupplier;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
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

    public void moveAll() {
        moveAllWith(RandomNumberGenerator::generate);
    }

    public void moveAllWith(IntSupplier randomSupplier) {
        for (Car car : cars) {
            int randomValue = randomSupplier.getAsInt();
            car.moveIfPossible(randomValue);
        }
    }

    public String formatRoundResult() {
        StringBuilder result = new StringBuilder();
        for (Car car : cars) {
            result.append(formatCarPosition(car));
            result.append(System.lineSeparator());
        }
        return result.toString();
    }

    private String formatCarPosition(Car car) {
        String positionSymbol = "-";
        String separator = " : ";
        return car.getName() + separator + positionSymbol.repeat((int) car.getPosition());
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