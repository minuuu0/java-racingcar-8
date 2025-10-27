package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 여러_대_자동차를_생성한다() {
        List<String> carList = List.of("pobi", "woni", "jun");

        Cars cars = new Cars(carList);

        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    void 우승자가_한_명일_때_우승자를_반환한다() {
        Cars cars = new Cars(
                new Car("pobi", 2),
                new Car("woni", 0),
                new Car("jun", 1)
        );

        List<String> winners = cars.getWinners();

        assertThat(winners).hasSize(1);
        assertThat(winners).containsExactly("pobi");
    }

    @Test
    void 우승자가_여러_명일_때_모든_우승자를_반환한다() {
        Cars cars = new Cars(
                new Car("pobi", 2),
                new Car("woni", 1),
                new Car("jun", 2)
        );

        List<String> winners = cars.getWinners();

        assertThat(winners).hasSize(2);
        assertThat(winners).containsExactlyInAnyOrder("pobi", "jun");
    }

}