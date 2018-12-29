package ui;

import Exception.OutofBoundPeriodException;
import Model.WishInfo;
import implementations.WishList.WLMessage;

import implementations.WishList.WishList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Calendar;

public class UIWishList extends JFrame implements ActionListener {

    private JButton _button_previous, _button_calculate, _button_saveRegular, _button_saveSpecial, _button_specialConfirm;

    private JLabel _title_wishList, _title_price, _title_period, _title_result, _title_wishName, _title_food_2, _title_necessity_2,
            _title_transit_2, _title_others_2, _title_food_1, _title_necessity_1, _title_transit_1, _title_others_1,
            _title_saveSuccessfully, _title_saveFailed, _title_firstMonthForSpecial, _title_lastMonthForSpecial,
            _title_resultFirstMonthsForSpecial, _title_resultLastMonthForSpecial, _title_confirmPlanRegular, _title_confirmPlanSpecial;

    private JPanel _panel_0, _panel_00, _panel_1, _panel_2, _panel_3, _panel_4, _panel_5, _panel_7, _panel_8, _panel_9, _panel_10,
            _panel_11, _panel_12, _panel_13, _panel_14, _panel_15, _panel_16, _panel_17;

    private JTextField _textField_price, _textField_period, _textField_wishName, _textField_food_1, _textField_necessity_1,
            _textField_transit_1, _textField_others_1, _textField_food_2, _textField_necessity_2, _textField_transit_2,
            _textField_others_2;

    UIWishList() {

        {
            _button_previous = new JButton("previous");
            _button_previous.addActionListener(this);
            _button_calculate = new JButton("Calculate");
            _button_calculate.addActionListener(this);
            _button_saveRegular = new JButton("Plan A: Save from your balance directly");
            _button_saveRegular.addActionListener(this);
            _button_saveSpecial = new JButton("Plan B: Save from specific types of expenditure");
            _button_saveSpecial.addActionListener(this);
            _button_specialConfirm = new JButton("Confirm Save Plan");
            _button_calculate.addActionListener(this);
            _button_specialConfirm.setVisible(false);
        }

        {
            _title_wishList = new JLabel("WISH-LIST");
            _title_price = new JLabel("price $");
            _title_period = new JLabel("period");
            _title_result = new JLabel("");
            _title_food_1 = new JLabel("Food -$");
            _title_necessity_1 = new JLabel("Necessity -$");
            _title_transit_1 = new JLabel("Transit -$");
            _title_others_1 = new JLabel("Others -$");
            _title_wishName = new JLabel("Wish-name: ");
            _title_saveSuccessfully = new JLabel("Save successfully. Go check out in Manage Money!");
            _title_saveFailed = new JLabel("Save unsuccessfully. Please check the numbers again.");
            _title_firstMonthForSpecial = new JLabel("SavePlan for the months except for the last one: ");
            _title_lastMonthForSpecial = new JLabel("SavePlan for the last month: ");
            _title_resultFirstMonthsForSpecial = new JLabel("");
            _title_resultLastMonthForSpecial = new JLabel("");
            _title_food_2 = new JLabel("Food -$");
            _title_necessity_2 = new JLabel("Necessity -$");
            _title_transit_2 = new JLabel("Transit -$");
            _title_others_2 = new JLabel("Others -$");
            _title_confirmPlanRegular = new JLabel("");
            _title_confirmPlanSpecial = new JLabel("");

        }

        {
            _textField_price = new JTextField(5);
            _textField_period = new JTextField(5);
            _textField_wishName = new JTextField(16);

            _textField_food_1 = new JTextField(5);
            _textField_necessity_1 = new JTextField(5);
            _textField_transit_1 = new JTextField(5);
            _textField_others_1 = new JTextField(5);

            _textField_food_2 = new JTextField(5);
            _textField_necessity_2 = new JTextField(5);
            _textField_transit_2 = new JTextField(5);
            _textField_others_2 = new JTextField(5);

            _textField_food_1.setText("0");
            _textField_necessity_1.setText("0");
            _textField_transit_1.setText("0");
            _textField_others_1.setText("0");

            _textField_food_2.setText("0");
            _textField_necessity_2.setText("0");
            _textField_transit_2.setText("0");
            _textField_others_2.setText("0");
        }

        {
            _panel_0 = new JPanel();
            _panel_00 = new JPanel();
            _panel_1 = new JPanel();
            _panel_2 = new JPanel();
            _panel_3 = new JPanel();
            _panel_4 = new JPanel();
            _panel_5 = new JPanel();
            _panel_7 = new JPanel();
            _panel_8 = new JPanel();
            _panel_8.setVisible(false);
            _panel_9 = new JPanel();
            _panel_9.setVisible(false);
            _panel_10 = new JPanel();
            _panel_11 = new JPanel();
            _panel_11.setVisible(false);
            _panel_12 = new JPanel();
            _panel_13 = new JPanel();
            _panel_13.setVisible(false);
            _panel_14 = new JPanel();
            _panel_14.setVisible(false);
            _panel_15 = new JPanel();
            _panel_15.setVisible(false);
            _panel_16 = new JPanel();
            _panel_16.setVisible(false);
            _panel_17 = new JPanel();
            _panel_17.setVisible(false);

            _panel_0.add(_title_wishList);
            _panel_00.add(_button_previous);
            _panel_1.add(_title_price);
            _panel_1.add(_textField_price);
            _panel_2.add(_title_period);
            _panel_2.add(_textField_period);
            _panel_3.add(_button_calculate);
            _panel_4.add(_title_result);
            _panel_5.add(_button_saveRegular);
            _panel_7.add(_button_saveSpecial);
            _panel_8.add(_title_food_1);
            _panel_8.add(_textField_food_1);
            _panel_8.add(_title_transit_1);
            _panel_8.add(_textField_transit_1);
            _panel_8.add(_title_necessity_1);
            _panel_8.add(_textField_necessity_1);
            _panel_8.add(_title_others_1);
            _panel_8.add(_textField_others_1);
            _panel_9.add(_title_food_2);
            _panel_9.add(_textField_food_2);
            _panel_9.add(_title_transit_2);
            _panel_9.add(_textField_transit_2);
            _panel_9.add(_title_necessity_2);
            _panel_9.add(_textField_necessity_2);
            _panel_9.add(_title_others_2);
            _panel_9.add(_textField_others_2);
            _panel_10.add(_button_specialConfirm);
            _panel_11.add(_title_firstMonthForSpecial);
            _panel_11.add(_title_resultFirstMonthsForSpecial);
            _panel_12.add(_title_wishName);
            _panel_12.add(_textField_wishName);
            _panel_13.add(_title_saveSuccessfully);
            _panel_14.add(_title_lastMonthForSpecial);
            _panel_14.add(_title_resultLastMonthForSpecial);
            _panel_15.add(_title_saveFailed);
            _panel_16.add(_title_confirmPlanRegular);
            _panel_17.add(_title_confirmPlanSpecial);

        }

        {
            this.add(_panel_0);
            this.add(_panel_12);
            this.add(_panel_1);
            this.add(_panel_2);
            this.add(_panel_3);
            this.add(_panel_4);
            this.add(_panel_5);
            this.add(_panel_7);
            this.add(_panel_11);
            this.add(_panel_8);
            this.add(_panel_14);
            this.add(_panel_9);
            this.add(_panel_10);
            this.add(_panel_13);
            this.add(_panel_16);
            this.add(_panel_17);
            this.add(_panel_15);
            this.add(_panel_00);
        }

        {
            this.setLayout(new GridLayout(18, 6));
            this.setTitle("WishList");
            this.setSize(600, 800);
            this.setLocation(400, 300);
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            this.setVisible(true);
        }
    }

    private int price;
    private int period;
    private double resultRounded;
    private double resultLeft;
    private WishList wishList;
    private Calendar calendar = Calendar.getInstance();


    public void actionPerformed(ActionEvent e){

        if (e.getActionCommand().equals("Calculate")) {

            _button_saveRegular.setEnabled(true);
            _button_saveSpecial.setEnabled(true);

            try {
                price = Integer.parseInt(_textField_price.getText());
                period = Integer.parseInt(_textField_period.getText());

            } catch (NumberFormatException e1) {
                _button_saveRegular.setEnabled(false);
                _button_saveSpecial.setEnabled(false);
                // error message presented in UI
            }

            wishList.checkBounding(period);

            resultRounded = wishList.getMoneyRounded(price, period);
            resultLeft = wishList.getMoneyLeft(resultRounded, price, period);

            WLMessage wlMessage = new WLMessage();

            _title_result.setText(wlMessage.savePlan(price, period));
            _title_resultFirstMonthsForSpecial.setText("$" + Double.toString(resultRounded));
            _title_resultLastMonthForSpecial.setText("$" + Double.toString(resultLeft));


            final WishInfo wishInfo = new WishInfo();
            final WishList wishList = new WishList();

            wishInfo.setResultRounded(resultRounded);
            wishInfo.setResultLeft(resultLeft);
            wishInfo.setPrice(price);
            wishInfo.setPeriod(period);
            wishInfo.setStartingYear(Calendar.YEAR);
            wishInfo.setStartingMonth(Calendar.MONTH);
            wishInfo.setEndYear(Calendar.YEAR + wishList.checkEndingYear(Calendar.MONTH, period));
            wishInfo.setEndMonth(wishList.checkEndingMonth(Calendar.MONTH, period));

            _button_saveSpecial.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == _button_saveSpecial) {
                        saveSpecial();
                    }
                }
            });

            _button_saveRegular.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String wishName = _textField_wishName.getText();
                    int startingYear = calendar.get(Calendar.YEAR);
                    int startingMonth = calendar.get(Calendar.MONTH);
                    double endYear = startingYear + Math.floor(period / 12);
                    int endMonth = startingMonth + period % 12;

                    if (e.getSource() == _button_saveRegular) {
                        _panel_8.setVisible(false);
                        _panel_9.setVisible(false);
                        _panel_11.setVisible(false);
                        _panel_14.setVisible(false);
                        _button_specialConfirm.setVisible(false);
                        _panel_13.setVisible(true);
                        int finalPeriod = 0;
                        //_title_confirmPlanRegular.setText(wishList.confirmSavePlan(finalPeriod, foodDeducted_1, foodDeducted_2, necessityDeducted_1, necessityDeducted_2, transitDeducted_1, transitDeducted_2, othersDeducted_1, othersDeducted_2) + _title_result.getText());
                        _panel_16.setVisible(true);
                    }
                }
            });

        } else if (e.getActionCommand().equals("previous")) {
            dispose();
            try {
                new UIMain();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }

    }

    private void saveSpecial() {
        _panel_13.setVisible(false);
        _panel_16.setVisible(false);
        _panel_11.setVisible(true);
        _panel_8.setVisible(true);
        _panel_9.setVisible(true);
        _panel_14.setVisible(true);
        _button_specialConfirm.setVisible(true);

        _button_specialConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double foodDeducted_1 = 0;
                double necessityDeducted_1 = 0;
                double transitDeducted_1 = 0;
                double othersDeducted_1 = 0;
                double foodDeducted_2 = 0;
                double necessityDeducted_2 = 0;
                double transitDeducted_2 = 0;
                double othersDeducted_2 = 0;

                try {
                    foodDeducted_1 = Integer.parseInt(_textField_food_1.getText());
                    necessityDeducted_1 = Integer.parseInt(_textField_necessity_1.getText());
                    transitDeducted_1 = Integer.parseInt(_textField_transit_1.getText());
                    othersDeducted_1 = Integer.parseInt(_textField_others_1.getText());
                    foodDeducted_2 = Integer.parseInt(_textField_food_2.getText());
                    necessityDeducted_2 = Integer.parseInt(_textField_necessity_2.getText());
                    transitDeducted_2 = Integer.parseInt(_textField_transit_2.getText());
                    othersDeducted_2 = Integer.parseInt(_textField_others_2.getText());
                } catch (NumberFormatException ignored) {
                }

                if (e.getSource() == _button_specialConfirm) {
                    specialConfirm(foodDeducted_1, necessityDeducted_1, transitDeducted_1, othersDeducted_1,
                            foodDeducted_2, necessityDeducted_2, transitDeducted_2, othersDeducted_2,
                            resultRounded, resultLeft, price, period);
                }
            }
        });

    }


    private void specialConfirm(double foodDeducted_1, double necessityDeducted_1, double transitDeducted_1, double othersDeducted_1,
                                double foodDeducted_2, double necessityDeducted_2, double transitDeducted_2, double othersDeducted_2,
                                double finalResultRounded, double resultLeft, int finalPrice, int finalPeriod) {
        WishList wishList = new WishList();
        if (foodDeducted_1 + necessityDeducted_1 + transitDeducted_1 + othersDeducted_1 == finalResultRounded &&
                foodDeducted_2 + necessityDeducted_2 + transitDeducted_2 + othersDeducted_2 == resultLeft) {
            _panel_13.setVisible(true);
            _panel_15.setVisible(false);
            _panel_17.setVisible(true);
            if (finalPrice % finalPeriod == 0) {
                _title_confirmPlanSpecial.setText(wishList.confirmSavePlanInt(finalPeriod, foodDeducted_1,
                        necessityDeducted_1, transitDeducted_1, othersDeducted_1));
            } else {
                _title_confirmPlanSpecial.setText(wishList.confirmSavePlan(finalPeriod, foodDeducted_1,
                        foodDeducted_2, necessityDeducted_1, necessityDeducted_2, transitDeducted_1,
                        transitDeducted_2, othersDeducted_1, othersDeducted_2));
            }
        } else {
            _panel_15.setVisible(true);
            _panel_13.setVisible(false);
            _panel_16.setVisible(false);
            _panel_17.setVisible(false);
        }
    }

}
