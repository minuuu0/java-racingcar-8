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
            OutputView.printRoundResult(cars.formatRoundResult());
        }
    }

    void announceWinners() {
        List<String> winners = cars.getWinners();
        OutputView.printWinners(winners);
    }

    private void playRound() {
        cars.moveAll();
    }
}