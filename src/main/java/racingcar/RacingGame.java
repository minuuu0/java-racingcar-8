package racingcar;

import java.util.List;
import racingcar.car.Cars;

class RacingGame {
    private final Cars cars;

    RacingGame(List<String> carNames) {
        this.cars = new Cars(carNames);
    }

    void play(int attemptCount) {
        OutputView.printRaceStart();
        for (int i = 0; i < attemptCount; i++) {
            cars.moveAllWith(RandomNumberGenerator::generate);
            OutputView.printRoundResult(cars.getCarNames(), cars.getCarPositions());
        }
    }

    void announceWinners() {
        List<String> winners = cars.getWinners();
        OutputView.printWinners(winners);
    }

}