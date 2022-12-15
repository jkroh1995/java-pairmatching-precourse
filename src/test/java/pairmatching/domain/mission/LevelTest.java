package pairmatching.domain.mission;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LevelTest {

    @Test
    @DisplayName("잘못된 입력 대한 예외 처리")
    void testValidateWrongInput() {
        assertThatThrownBy(() -> new Level("이상한 레벨"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("올바른 입력은 예외 처리하지 않음을 테스트")
    void testValidateCorrectInput() {
        assertDoesNotThrow(() -> new Level("레벨1"));
        assertDoesNotThrow(() -> new Level("레벨2"));
        assertDoesNotThrow(() -> new Level("레벨3"));
        assertDoesNotThrow(() -> new Level("레벨4"));
        assertDoesNotThrow(() -> new Level("레벨5"));
    }
}
