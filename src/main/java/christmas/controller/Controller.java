package christmas.controller;

import christmas.view.InputView;
import christmas.view.OutputView;

public class Controller {
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();

    public void start() {
        outputView.printWelcome();

        inputView.readDate();
    }
}
