package racingcar;

import java.util.List;

class RacingGame {
    private final Cars cars;

    RacingGame(List<String> carNames) {
        this.cars = new Cars(carNames);
    }

    void play(int attemptCount) {
        OutputView.printRaceStart();
        for (int i = 0; i < attemptCount; i++) {
            playRound();
            OutputView.printRoundResult(cars.getCars());
        }
    }

    void announceWinners() {
        List<String> winners = cars.getWinners();
        OutputView.printWinners(winners);
    }

    private void playRound() {
        for (Car car : cars.getCars()) {
            int randomValue = RandomNumberGenerator.generate();
            car.moveIfPossible(randomValue);
        }
    }
}