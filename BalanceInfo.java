package Model;

import implementations.WishList.WLSpecial;
import implementations.WishList.WishList;

public class BalanceInfo {

    private int _id;
    private int _userid;
    private int _income;
    private double _balance;
    private double _foodBalance;
    private double _necessityBalance;
    private double _transitBalance;
    private double _othersBalance;

    public BalanceInfo() {
        this._id = 0;
        this._userid = 0;
        this._income = 0;
        this._balance = 0;
        this._foodBalance = 0;
        this._necessityBalance = 0;
        this._transitBalance = 0;
        this._othersBalance = 0;
    }

    public BalanceInfo(int id, int userid, int income, double balance, double foodExpense, double necessityExpense, double transitExpense, double othersExpense) {
        this._id = id;
        this._userid = userid;
        this._income = income;
        this._foodBalance = foodExpense;
        this._necessityBalance = necessityExpense;
        this._transitBalance = transitExpense;
        this._othersBalance = othersExpense;
    }

    public int get_income() {
        return _income;
    }

    public void set_income(int _income) {
        this._income = _income;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_userid() {
        return _userid;
    }

    public void set_userid(int _userid) {
        this._userid = _userid;
    }

    public double get_balance() {
        return _balance;
    }

    public void set_balance(double _balance) {
        this._balance = _balance;

    }

    public double get_foodBalance() {
        return _foodBalance;
    }

    public void set_foodBalance(double _foodExpense) {
        this._foodBalance = _foodExpense;
    }

    public double get_necessityBalance() {
        return _necessityBalance;
    }

    public void set_necessityBalance(double _necessityExpense) {
        this._necessityBalance = _necessityExpense;
    }

    public double get_transitBalance() {
        return _transitBalance;
    }

    public void set_transitBalance(double _transitExpense) {
        this._transitBalance = _transitExpense;
    }

    public double get_othersBalance() {
        return _othersBalance;
    }

    public void set_othersBalance(double _othersExpense) {
        this._othersBalance = _othersExpense;
    }
}
