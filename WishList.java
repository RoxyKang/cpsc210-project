package implementations.WishList;


public class WishList{

    public double getMoneyRounded(int price, int period){
        if (period > 0 && price > 0){
            int result = price/period;
            return Math.floor(result);
        }
        return 0;
    }

    public double getMoneyLeft(double result_rounded, int price, int period){
        return price - (result_rounded * period);
    }

    public void checkBounding(int period) {
    }

    public int checkEndingYear(int month, int period) {
        return 0;
    }

    public int checkEndingMonth(int month, int period) {
        return 0;
    }

    public String confirmSavePlan(int finalPeriod, double foodDeducted_1, double foodDeducted_2, double necessityDeducted_1, double necessityDeducted_2, double transitDeducted_1, double transitDeducted_2, double othersDeducted_1, double othersDeducted_2) {
        return null;
    }

    public String confirmSavePlanInt(int finalPeriod, double foodDeducted_1, double necessityDeducted_1, double transitDeducted_1, double othersDeducted_1) {
        return null;
    }
}
