package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = InputView.inputCarNames();
        Cars cars = new Cars(carNames);
        int attemptCount = InputView.inputAttemptCount();
    }
}
