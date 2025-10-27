package racingcar;

import java.util.List;

class OutputView {

    private static final String WINNER_SEPARATOR = ", ";

    private OutputView() {
    }

    static void printRaceStart() {
        System.out.println();
        System.out.println("실행 결과");
    }

    static void printRoundResult(String roundResult) {
        System.out.print(roundResult);
        System.out.println();
    }

    static void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(WINNER_SEPARATOR, winners));
    }
}