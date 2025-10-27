package racingcar;

import java.util.List;
import racingcar.car.Cars;

class RacingGame {
    private final Cars cars;

    RacingGame(List<String> carNames) {
        this.cars = new Cars(carNames);
    }

    void playRound() {
        int randomValue = RandomNumberGenerator.generate();
        cars.moveAll(randomValue);
    }

    List<String> getCarNames() {
        return cars.getCarNames();
    }

    List<Long> getCarPositions() {
        return cars.getCarPositions();
    }

    List<String> getWinners() {
        return cars.getWinners();
    }
}