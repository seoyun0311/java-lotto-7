package lotto.Controller;

import lotto.Model.Lotto;
import lotto.Model.LottoGenerator;
import lotto.Model.WinningLotto;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.List;

public class LottoController {

    public void lottoController() {
        int price = InputView.priceInput();

        LottoGenerator generator = new LottoGenerator();
        List<Lotto> allLottos = generator.generateLottos(price);
        OutputView.showLottoCount(allLottos.size());
        OutputView.showAllLottos(allLottos);

        List<Integer> winNumbers = InputView.winInput();

        int bonus = InputView.bonusInput(winNumbers);

        WinningLotto winningLotto = new WinningLotto(winNumbers, bonus);

    }
}

