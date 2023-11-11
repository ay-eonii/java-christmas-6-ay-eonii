package christmas.controller;

import christmas.view.OutputView;

public class Controller {
    private OutputView outputView = new OutputView();

    public void start() {
        outputView.printWelcome();
    }
}
