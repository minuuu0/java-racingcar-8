package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    void 여러_대_자동차를_생성한다() {
        List<String> carList = List.of("pobi", "woni", "jun");

        Cars cars = new Cars(carList);

        assertThat(cars.size()).isEqualTo(3);
    }
    
}