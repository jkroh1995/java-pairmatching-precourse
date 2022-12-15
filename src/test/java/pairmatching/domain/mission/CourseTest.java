package pairmatching.domain.mission;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CourseTest{

    @Test
    @DisplayName("잘못된 입력 대한 예외 처리")
    void testValidateWrongInput() {
        assertThatThrownBy(() -> new Course("이상한코스"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("올바른 입력은 예외 처리하지 않음을 테스트")
    void testValidateCorrectInput() {
        assertDoesNotThrow(() -> new Course("백엔드"));
        assertDoesNotThrow(() -> new Course("프론트엔드"));
    }
}
