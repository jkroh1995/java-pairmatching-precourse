package pairmatching.domain.mission;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MissionTest {

    @Test
    @DisplayName("잘못된 미션 입력을 예외처리")
    void testValidateWrongInput() {
        assertThatThrownBy(() -> new Mission(new Level("레벨1"),"이상한미션"));
    }

    @Test
    @DisplayName("미션이 없는 레벨에서 미션 입력시 예외처리")
    void testValidateWrongLevel() {
        assertThatThrownBy(() -> new Mission(new Level("레벨3"),"레벨3의미션"));
    }

    @Test
    @DisplayName("올바른 입력은 예외 처리하지 않음을 테스트")
    void testValidateCorrectInput() {
        assertDoesNotThrow(() -> new Mission(new Level("레벨2"), "장바구니"));
        assertDoesNotThrow(() -> new Mission(new Level("레벨4"), "배포"));
        assertDoesNotThrow(() -> new Mission(new Level("레벨1"), "숫자야구게임"));
    }
}
