package ui;

import Model.BalanceInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UISetBudget extends JFrame implements ActionListener {
    private JButton _button_previous, _button_confirm = null;
    private JLabel _title_confirm, _title_confirmMoney, _title_kinds, _title_budget, _title_food, _title_necessity,
            _title_transit, _title_others, _title_confirmFood, _title_confirmNecessity, _title_confirmTransit,
            _title_confirmOthers, _title_wrongNum = null;
    private JPanel _panel_0, _panel_1, _panel_2, _panel_3, _panel_4, _panel_5, _panel_6, _panel_7, _panel_8, _panel_9,
            _panel_10 = null;
    private JTextField _textField_budget, _textField_food, _textField_necessity, _textField_transit, _textField_others = null;

    UISetBudget() {
        {
            _textField_budget = new JTextField(5);
            _textField_budget.setText("0");
            _textField_food = new JTextField(5);
            _textField_food.setText("0");
            _textField_necessity = new JTextField(5);
            _textField_necessity.setText("0");
            _textField_transit = new JTextField(5);
            _textField_transit.setText("0");
            _textField_others = new JTextField(5);
            _textField_others.setText("0");

        }
        {
            _button_previous = new JButton("Previous");
            _button_confirm = new JButton("Confirm");

            _button_previous.addActionListener(this);
            _button_confirm.addActionListener(this);
        }

        {
            _title_confirm = new JLabel("Your balance now is: ");
            _title_confirmMoney = new JLabel("");
            _title_budget = new JLabel("Your budget for this month is:");
            _title_food = new JLabel("Food $");
            _title_necessity = new JLabel("Necessity $");
            _title_transit = new JLabel("Transit $");
            _title_others = new JLabel("Others $");
            _title_kinds = new JLabel("How do you wanna spend your money?");
            _title_confirmFood = new JLabel("Food: +");
            _title_confirmNecessity = new JLabel("Necessity: +");
            _title_confirmTransit = new JLabel("Transit: +");
            _title_confirmOthers = new JLabel("Others +");
            _title_wrongNum = new JLabel("Sorry. Please check your numbers again.");
        }

        {
            _panel_0 = new JPanel();
            _panel_1 = new JPanel();
            _panel_2 = new JPanel();
            _panel_3 = new JPanel();
            _panel_3.setVisible(false);
            _panel_4 = new JPanel();
            _panel_5 = new JPanel();
            _panel_6 = new JPanel();
            _panel_7 = new JPanel();
            _panel_8 = new JPanel();
            _panel_8.setVisible(false);
            _panel_9 = new JPanel();
            _panel_9.setVisible(false);
            _panel_10 = new JPanel();
            _panel_10.setVisible(false);


            _panel_0.add(_button_previous);
            _panel_1.add(_textField_budget);
            _panel_2.add(_button_confirm);
            _panel_3.add(_title_confirm);
            _panel_3.add(_title_confirmMoney);
            _panel_4.add(_title_budget);
            _panel_5.add(_title_food);
            _panel_5.add(_textField_food);
            _panel_5.add(_title_necessity);
            _panel_5.add(_textField_necessity);
            _panel_6.add(_title_transit);
            _panel_6.add(_textField_transit);
            _panel_6.add(_title_others);
            _panel_6.add(_textField_others);
            _panel_7.add(_title_kinds);
            _panel_8.add(_title_confirmFood);
            _panel_8.add(_title_confirmNecessity);
            _panel_9.add(_title_confirmTransit);
            _panel_9.add(_title_confirmOthers);
            _panel_10.add(_title_wrongNum);

        }

        {
            this.add(_panel_4);
            this.add(_panel_1);
            this.add(_panel_7);
            this.add(_panel_5);
            this.add(_panel_6);
            this.add(_panel_3);
            this.add(_panel_8);
            this.add(_panel_9);
            this.add(_panel_10);
            this.add(_panel_2);
            this.add(_panel_0);
        }

        {
            this.setLayout(new GridLayout(11, 7));
            this.setTitle("Manage Budget");
            this.setSize(500, 500);
            this.setLocation(400, 300);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        _button_confirm.setEnabled(true);
        if (e.getSource() == _button_confirm) {
            int budget = Integer.parseInt(_textField_budget.getText());
            int food = Integer.parseInt(_textField_food.getText());
            int necessity = Integer.parseInt(_textField_necessity.getText());
            int transit = Integer.parseInt(_textField_transit.getText());
            int others = Integer.parseInt(_textField_others.getText());

            if (food + necessity + transit + others == budget) {
                BalanceInfo balanceInfo = new BalanceInfo();
                balanceInfo.set_income(budget);
                balanceInfo.set_foodBalance(food);
                balanceInfo.set_necessityBalance(necessity);
                balanceInfo.set_transitBalance(transit);
                balanceInfo.set_othersBalance(others);

                _title_confirmMoney.setText("+" + _textField_budget.getText() + "$");
                _title_confirmFood.setText(_title_confirmFood.getText() + _textField_food.getText() + "$");
                _title_confirmNecessity.setText(_title_confirmNecessity.getText() + _textField_necessity.getText() + "$");
                _title_confirmTransit.setText(_title_confirmTransit.getText() + _textField_transit.getText() + "$");
                _title_confirmOthers.setText(_title_confirmOthers.getText() + _textField_others.getText() + "$");

                _panel_10.setVisible(false);
                _panel_3.setVisible(true);
                _panel_8.setVisible(true);
                _panel_9.setVisible(true);
            } else {
                _panel_10.setVisible(true);
            }

            _button_confirm.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == _button_previous) {
                        dispose();
                        new UIManageMoney();
                    }
                }
            });
        } else if (e.getSource() == _button_previous) {
            dispose();
            new UIManageMoney();
        }
    }
}
