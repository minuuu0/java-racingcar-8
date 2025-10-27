package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

class InputView {

    private static final String CAR_NAME_DELIMITER = ",";

    private InputView() {
    }

    static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        return Arrays.stream(carNamesInput.split(CAR_NAME_DELIMITER))
                .toList();
    }

    static int inputAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String attemptCountInput = Console.readLine();
        return InputValidator.parseAndValidateAttemptCount(attemptCountInput);
    }
}
