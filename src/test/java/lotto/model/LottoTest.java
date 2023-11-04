package lotto.model;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {
    @DisplayName("로또가 잘 생성된다")
    @Test
    void createLotto(){
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);

        Lotto lotto = new Lotto(validNumbers);

        assertThat(lotto).isNotNull();
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6자리여야 합니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 중복되지 않아야 합니다.");
    }

    @DisplayName("로또 번호가 1~45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRange(){
        assertThatThrownBy(() -> new Lotto(List.of(1,2,3,4,5,46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }


}