package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @Test
    void 자동차_이름을_입력하면_자동차가_생성된다() {
        String carName = "pobi";

        Car car = new Car(carName);

        assertThat(car.getName()).isEqualTo("pobi");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t", "\n"})
    void 자동차_이름이_null_또는_공백이면_예외를_발생시킨다(String invalidName) {
        assertThatThrownBy(() -> new Car(invalidName))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi.woni", "pobi woni", "pobi!", "pobi@", "a.b", "123", "pobi123", "!@#"})
    void 자동차_이름에_영문자와_한글_외_다른_문자가_포함되면_예외를_발생시킨다(String invalidName) {
        assertThatThrownBy(() -> new Car(invalidName))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름을_6자_이상_작성하면_IllegalArgumentException을_발생한다() {
        String carName = "sixsix";

        assertThatThrownBy(() -> new Car(carName))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 랜덤값이_4_이상이면_전진한다() {
        Car car = new Car("pobi");

        car.moveIfPossible(4);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 랜덤값이_3_이하면_전진하지_않는다() {
        Car car = new Car("pobi");

        car.moveIfPossible(3);

        assertThat(car.getPosition()).isEqualTo(0);
    }
}
