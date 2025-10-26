package racingcar;

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
    void 자동차_목록을_가져온다() {
        List<String> carList = List.of("pobi", "woni", "jun");
        Cars cars = new Cars(carList);

        List<Car> carsList = cars.getCars();

        assertThat(carsList).hasSize(3);
        assertThat(carsList.get(0).getName()).isEqualTo("pobi");
        assertThat(carsList.get(1).getName()).isEqualTo("woni");
        assertThat(carsList.get(2).getName()).isEqualTo("jun");
    }

    @Test
    void 우승자가_한_명일_때_우승자를_반환한다() {
        List<String> carList = List.of("pobi", "woni", "jun");
        Cars cars = new Cars(carList);

        cars.getCars().get(0).moveIfPossible(4);

        List<String> winners = cars.getWinners();

        assertThat(winners).hasSize(1);
        assertThat(winners).containsExactly("pobi");
    }

    @Test
    void 우승자가_여러_명일_때_모든_우승자를_반환한다() {
        List<String> carList = List.of("pobi", "woni", "jun");
        Cars cars = new Cars(carList);

        cars.getCars().get(0).moveIfPossible(4);
        cars.getCars().get(0).moveIfPossible(4);
        cars.getCars().get(2).moveIfPossible(4);
        cars.getCars().get(2).moveIfPossible(4);

        List<String> winners = cars.getWinners();

        assertThat(winners).hasSize(2);
        assertThat(winners).containsExactlyInAnyOrder("pobi", "jun");
    }

}