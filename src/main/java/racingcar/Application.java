package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = InputView.inputCarNames();
        int attemptCount = InputView.inputAttemptCount();

        RacingGame game = new RacingGame(carNames);

        OutputView.printRaceStart();
        for (int i = 0; i < attemptCount; i++) {
            game.playRound();
            OutputView.printRoundResult(game.getCarNames(), game.getCarPositions());
        }

        OutputView.printWinners(game.getWinners());
    }
}
