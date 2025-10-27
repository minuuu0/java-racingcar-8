package racingcar;

import java.util.List;

class OutputView {

    private static final String WINNER_SEPARATOR = ", ";
    private static final String POSITION_SYMBOL = "-";
    private static final String NAME_POSITION_SEPARATOR = " : ";

    private OutputView() {
    }

    static void printRaceStart() {
        System.out.println();
        System.out.println("실행 결과");
    }

    static void printRoundResult(List<String> names, List<Long> positions) {
        for (int i = 0; i < names.size(); i++) {
            System.out.println(formatCarPosition(names.get(i), positions.get(i)));
        }
        System.out.println();
    }

    private static String formatCarPosition(String name, long position) {
        return name + NAME_POSITION_SEPARATOR + POSITION_SYMBOL.repeat((int) position);
    }

    static void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(WINNER_SEPARATOR, winners));
    }
}