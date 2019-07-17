package ui;

import BLL.BLogin;
import Model.UserInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UILogin extends JFrame implements ActionListener {

    private JButton _button_signUp, _button_continue, _button_login = null;
    private JPanel _panel_5, _panel_4, _panel_3, _panel_2, _panel_1, _panel_0 = null;
    private JLabel _title_welcome, _title_signUp, _title_name, _title_msg, _title_pw = null;
    private JTextField _textField_username = null;
    private JPasswordField _passwordField_password = null;

    UILogin() {

        {
            _button_login = new JButton("Login");
            _button_login.addActionListener(this);
            _button_continue = new JButton("Continue");
            _button_continue.addActionListener(this);
            _button_continue.setVisible(false);
            _button_signUp = new JButton("Sign up here!");
            _button_signUp.addActionListener(this);
        }

        {
            _title_name = new JLabel("Username");
            _title_pw = new JLabel("Password");
            _title_msg = new JLabel("");
            _title_signUp = new JLabel("Don't have an account yet?");
            _title_welcome = new JLabel("Welcome to MySimpleAccountBook!");
        }

        {
            _textField_username = new JTextField(16);
            _passwordField_password = new JPasswordField(16);
        }

        {
            _panel_1 = new JPanel();
            _panel_2 = new JPanel();
            _panel_3 = new JPanel();
            _panel_4 = new JPanel();
            _panel_5 = new JPanel();
            _panel_0 = new JPanel();
            _panel_0.add(_title_welcome);
            _panel_1.add(_title_name);
            _panel_1.add(_textField_username);
            _panel_2.add(_title_pw);
            _panel_2.add(_passwordField_password);
            _panel_3.add(_button_login);
            _panel_4.add(_title_msg);
            _panel_4.add(_button_continue);
            _panel_5.add(_title_signUp);
            _panel_5.add(_button_signUp);

        }

        {
            this.add(_panel_0);
            this.add(_panel_1);
            this.add(_panel_2);
            this.add(_panel_3);
            this.add(_panel_4);
            this.add(_panel_5);
        }

        {
            this.setLayout(new GridLayout(6, 1));
            this.setTitle("Login");
            this.setSize(400, 300);
            this.setLocation(400, 300);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Login")) {
            BLogin bLogin = new BLogin();
            String username = _textField_username.getText();
            String password = new String(_passwordField_password.getPassword());
            if (bLogin.match(new UserInfo(-1, username, password))) {
                setMsg("Logged In Successfully!");
                _button_continue.setVisible(true);
                _button_continue.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == _button_continue) {
                            dispose();
                            try {
                                new UIMain();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                });
            } else {
                setMsg("Logged In unsuccessfully!");
                _button_continue.setVisible(false);
            }
        }
        _button_signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == _button_signUp) {
                    dispose();
                    new UISignUp();
                }
            }
        });
    }

    private void setMsg(String strm) {
        _title_msg.setText(strm);
    }

}