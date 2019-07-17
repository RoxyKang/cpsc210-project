package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UIMain extends JFrame implements ActionListener {
    private JButton _button_manageMoney, _button_graph, _button_logOut = null;
    private JPanel _panel_1, _panel_2, _panel_3, _panel_4, _panel_5, _panel_6 = null;
    private JLabel _title_main, _title_web = null;
    private Web web = new Web();

    public UIMain() throws IOException {
        {
            _button_manageMoney = new JButton("Manage balance");
            _button_manageMoney.addActionListener(this);
            _button_graph = new JButton("Visualized balance");
            _button_graph.addActionListener(this);
            _button_logOut = new JButton("Log out");
            _button_logOut.addActionListener(this);
        }

        {
            _title_main = new JLabel("Welcome back to MySimpleAccountBook :)");
            _title_web = new JLabel(web.getMessage());
        }

        {
            _panel_1 = new JPanel();
            _panel_2 = new JPanel();
            _panel_3 = new JPanel();
            _panel_4 = new JPanel();
            _panel_5 = new JPanel();
            _panel_6 = new JPanel();

            _panel_1.add(_button_manageMoney);
            _panel_2.add(_button_graph);
            _panel_4.add(_button_logOut);
            _panel_5.add(_title_main);
            _panel_6.add(_title_web);
        }

        {
            this.add(_panel_5);
            this.add(_panel_1);
            this.add(_panel_2);
            this.add(_panel_3);
            this.add(_panel_4);
            this.add(_panel_6);
        }

        {
            this.setLayout(new GridLayout(6, 1));
            this.setTitle("Main page");
            this.setSize(400, 300);
            this.setLocation(400, 300);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == _button_manageMoney) {
            dispose();
            new UIManageMoney();
        }
        _button_graph.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == _button_graph) {
                    dispose();
                    new UIGraph();
                }
            }
        });

        _button_logOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == _button_logOut) {
                    dispose();
                    new UILogin();
                }
            }
        });

    }
}
