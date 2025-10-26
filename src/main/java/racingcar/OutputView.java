package racingcar;

import java.util.List;

public class OutputView {

    private static final String POSITION_SYMBOL = "-";
    private static final String NAME_POSITION_SEPARATOR = " : ";
    private static final String WINNER_SEPARATOR = ", ";

    private OutputView() {
    }

    static void printRaceStart() {
        System.out.println();
        System.out.println("실행 결과");
    }

    static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            printCarPosition(car);
        }
        System.out.println();
    }

    private static void printCarPosition(Car car) {
        System.out.print(car.getName());
        System.out.print(NAME_POSITION_SEPARATOR);
        System.out.println(POSITION_SYMBOL.repeat((int) car.getPosition()));
    }

    static void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(WINNER_SEPARATOR, winners));
    }
}