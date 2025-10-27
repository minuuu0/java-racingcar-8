package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi.woni", "pobi,woni.javaji", "pobi woni"})
    void 쉼표_외_다른_문자로_구분한_입력은_예외를_발생시킨다(String carNames) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carNames, "5"))
                        .isExactlyInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "1.5", "3a", "\n", " "})
    void 이동_횟수를_숫자로_입력하지_않으면_예외를_발생시킨다(String attemptCount) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", attemptCount))
                        .isExactlyInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이동_횟수를_0_이하로_입력하면_IllegalArgumentException을_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
