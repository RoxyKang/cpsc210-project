package implementations.WishList;

public class WLMessage extends WishList {

    public String savePlan(int price, int period) {
        String message;
        if (price <= 0 | period <= 0) {
            message = "Please make sure that your price and period are positive integers.";
        } else if (period > 24) {
            message = "Sorry, the maximum period length is 24 months";
        } else if (price % period == 0) {
            message = "Your SavePlan is: " + Double.toString(price / period) + "$ * " + Integer.toString(period) + " month";
        } else {
            double resultRounded = getMoneyRounded(price, period);
            double resultLeft = getMoneyLeft(resultRounded, price, period);
            message = "Your SavePlan is: " + Double.toString(resultRounded) + "$ * " + Integer.toString(period - 1) + " month" + "+" + Double.toString(resultLeft) + "$ for the " + period + "-th month";
        }
        return message;
    }

}
