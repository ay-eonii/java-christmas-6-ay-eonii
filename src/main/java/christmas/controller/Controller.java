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
        final Date date = inputView.readDate();
        final Order order = inputView.readMenu();
        displayOrder(date, order);

        final CustomBenefit customBenefit = new CustomBenefit(date);
        displayCustomBenefit(order, customBenefit);
    }

    private void displayOrder(Date date, Order order) {
        outputView.printPreview(date);
        outputView.printOrder(order.toString());
        outputView.printTotalPrice(order.getTotalPrice());
    }

    private void displayCustomBenefit(Order order, CustomBenefit customBenefit) {
        customBenefit.checkBenefit(order);
        outputView.printPresentation(customBenefit.getPresentation(order));
        outputView.printBenefit(customBenefit.toString());
        outputView.printTotalBenefit(customBenefit.getTotalBenefit());
        outputView.printExpectedPay(customBenefit.getExpectedPay(order));
        outputView.printBadge(Badge.determineBadge(customBenefit));
    }
}
