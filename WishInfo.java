package Model;

public class WishInfo {

    private int _userid;
    private String _wishName;
    private int _price;
    private int _period;
    private double _resultRounded;
    private double _resultLeft;
    private int _startingYear;
    private int _startingMonth;
    private double _endYear;
    private int _endMonth;

    public WishInfo(){
        this._userid = -1;
        this._wishName = "";
        this._price = 0;
        this._period = 0;
        this._resultRounded = 0;
        this._resultLeft = 0;
        this._startingYear = 0;
        this._startingMonth = 0;
        this._endYear = 0;
        this._endMonth = 0;
    }

    public WishInfo(int userid, String wishName, int price, int period, double resultRounded, double resultLeft, int startingYear,
                    int startingMonth, double endYear, int endMonth) {

        this._userid = userid;
        this._wishName = wishName;
        this._price = price;
        this._period = period;
        this._resultRounded = resultRounded;
        this._resultLeft = resultLeft;
        this._startingYear = startingYear;
        this._startingMonth = startingMonth;
        this._endYear = endYear;
        this._endMonth = endMonth;
    }


    public void setUserId(int _userid){
        this._userid = _userid;
    }

    public int getUserId(){
        return this._userid;
    }

    public void setWishName(String _wishName){
        this._wishName = _wishName;
    }

    public String getWishName (){
        return this._wishName;
    }

    public void setPrice(int _price){
        this._price = _price;
    }

    public int getPrice(){
        return this._price;
    }

    public void setPeriod(int _period){
        this._period = _period;
    }

    public int getPeriod(){
        return this._period;
    }

    public void setResultRounded(double _resultRounded){
        this._resultRounded = _resultRounded;
    }

    public double getResultRounded(){
        return this._resultRounded;
    }

    public void setResultLeft(double _resultLeft){
        this._resultLeft = _resultLeft;
    }

    public double getResultLeft(){
        return this._resultLeft;
    }

    public void setStartingYear(int _startingYear){
        this._startingYear = _startingYear;
    }

    public int getStartingYear(){
        return this._startingYear;
    }

    public void setStartingMonth(int _startingMonth){
        this._startingMonth = _startingMonth;
    }

    public int getStartingMonth(){
        return this._startingMonth;
    }

    public void setEndYear(double _endYear){
        this._endYear = _endYear;
    }

    public double getEndYear(){
        return this._endYear;
    }
    public void setEndMonth(int _endMonth){
        this._endMonth = _endMonth;
    }

    public int getEndMonth(){
        return this._endMonth;
    }

}