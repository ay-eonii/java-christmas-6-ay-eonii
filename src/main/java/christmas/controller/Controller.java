package christmas.controller;

import christmas.domain.Badge;
import christmas.domain.Date;
import christmas.domain.Order;
import christmas.domain.benefit.CustomBenefit;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Controller {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void start() {
        outputView.printWelcome();

        Date date = inputView.readDate();
        Order order = inputView.readMenu();
        outputView.printPreview(date);
        outputView.printOrder(order.toString());
        outputView.printTotalPrice(order.getTotalPrice());

        final CustomBenefit customBenefit = new CustomBenefit(date);
        outputView.printPresentation(customBenefit.getPresentation(order));
        customBenefit.checkBenefit(order);
        outputView.printBenefit(customBenefit.toString());
        outputView.printTotalBenefit(customBenefit.getTotalBenefit());
        outputView.printExpectedPay(customBenefit.getExpectedPay(order));
        outputView.printBadge(Badge.determineBadge(customBenefit));
    }
}
