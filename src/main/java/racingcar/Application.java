package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = InputView.inputCarNames();
        RacingGame racingGame = new RacingGame(carNames);
        int attemptCount = InputView.inputAttemptCount();

        racingGame.play(attemptCount);
        racingGame.announceWinners();
    }
}
