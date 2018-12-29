package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UIManageMoney extends JFrame implements ActionListener {
    private JButton _button_previous, _button_budget, _button_total, _button_food, _button_necessity, _button_transit, _button_others = null;
    private JLabel _title_welcome = null;
    private JPanel _panel_0, _panel_1, _panel_2, _panel_3 = null;

    public UIManageMoney() {
        {
            _button_previous = new JButton("Previous");
            _button_budget = new JButton("Enter your Budget of this month here");
            _button_total = new JButton("Total");
            _button_food = new JButton("Food");
            _button_necessity = new JButton("Necessity");
            _button_transit = new JButton("Transit");
            _button_others = new JButton("Others");

            _button_previous.addActionListener(this);
            _button_budget.addActionListener(this);
            _button_total.addActionListener(this);
            _button_food.addActionListener(this);
            _button_necessity.addActionListener(this);
            _button_transit.addActionListener(this);
            _button_others.addActionListener(this);
        }

        {
            _title_welcome = new JLabel("BALANCE");
        }

        {
            _panel_0 = new JPanel();
            _panel_1 = new JPanel();
            _panel_2 = new JPanel();
            _panel_3 = new JPanel();

            _panel_0.add(_button_previous);
            _panel_1.add(_title_welcome);
            _panel_2.add(_button_budget);
            _panel_3.add(_button_total);
            _panel_3.add(_button_food);
            _panel_3.add(_button_necessity);
            _panel_3.add(_button_transit);
            _panel_3.add(_button_others);
        }

        {
            this.add(_panel_1);
            this.add(_panel_2);
            this.add(_panel_3);
            this.add(_panel_0);

        }

        {
            this.setLayout(new GridLayout(10, 10));
            this.setTitle("Balance");
            this.setSize(600, 500);
            this.setLocation(400, 300);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == _button_previous) {
            dispose();
            try {
                new UIMain();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == _button_budget) {
            dispose();
            new UISetBudget();
        }
    }
}
