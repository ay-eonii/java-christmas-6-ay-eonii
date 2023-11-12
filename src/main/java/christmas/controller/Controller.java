package christmas.controller;

import christmas.domain.Order;
import christmas.domain.benefit.CustomBenefit;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Controller {
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();

    public void start() {
        outputView.printWelcome();

        int date = inputView.readDate();

        String menu = inputView.readMenu();
        Order order = new Order(menu);
        outputView.printPreview(date);
        outputView.printOrder(order.toString());
        outputView.printTotalPrice(order.getTotalPrice());

        CustomBenefit customBenefit = new CustomBenefit(date);
        outputView.printPresentation(customBenefit.getPresentation(order));
        customBenefit.checkBenefit(order);
        outputView.printBenefit(customBenefit.toString());
        outputView.printTotalBenefit(customBenefit.getTotalBenefit());
    }
}
