package christmas.controller;

import christmas.domain.benefit.CustomBenefit;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Controller {
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();

    public void start() {
        outputView.printWelcome();

        int date = inputView.readDate();
        CustomBenefit customBenefit = new CustomBenefit(date);

        String menu = inputView.readMenu();
        outputView.printPreview();
        Order order = new Order(menu);
        outputView.printOrder(order.toString());

        int totalPrice = order.getTotalPrice();
        outputView.printTotalPrice(totalPrice);
        customBenefit.checkBenefit(order);
    }
}
