package lotto.controller;


import lotto.model.LottoManager;
import lotto.model.RandomLottoGenerator;
import lotto.model.lotto.Lotto;
import lotto.model.LottoResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView input = new InputView();
    private final OutputView output = new OutputView();
    private LottoManager manager = new LottoManager();

    public void run() {
        purchaseLotto();
        determineWinningLotto();
        calculateResult();
    }

    private void purchaseLotto() {
        int numberOfLottos = input.readPurchaseAmount() / Lotto.PRICE;
        output.printPurchaseAmount(numberOfLottos);

        manager.makeLottos(numberOfLottos, new RandomLottoGenerator());
        output.printLottos(manager.getPurchaseLottos());
    }


    private void determineWinningLotto() {
        Lotto lotto = input.readWinningNumbers();
        int bonusNumber = input.readBonusNumber();
        manager.makeWinningLotto(lotto, bonusNumber);
    }


    private void calculateResult(){
        output.printWinningHeader();
        LottoResult lottoResult = manager.calculateLottoResult();
        output.printWinnerStatus(lottoResult);
    }
}
