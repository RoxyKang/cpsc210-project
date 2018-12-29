package ui;

import SQLController.SQLHelper;
import Model.UserInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UISignUp extends JFrame implements ActionListener {

    private JButton _button_creatAccount, _button_signIn, _button_previous = null;
    private JPanel _panel_0, _panel_1, _panel_2, _panel_3, _panel_4, _panel_5, _panel_6, _panel_7 = null;
    private JLabel _title_username, _title_password, _title_passwordConfirm, _title_signUp, _title_createDone, _title_passwordNotMatch = null;
    private JTextField _textField_username = null;
    private JPasswordField _passwordField_password, _passwordField_passwordConfirm = null;

    UISignUp() {

        {
            _button_creatAccount = new JButton("Sign up");
            _button_creatAccount.addActionListener(this);
            _button_signIn = new JButton("Go to Sign in");
            _button_signIn.addActionListener(this);
            _button_previous = new JButton("Previous");
            _button_previous.addActionListener(this);
        }

        {
            _title_username = new JLabel("Username");
            _title_password = new JLabel("Password");
            _title_passwordConfirm = new JLabel("Confirm password");
            _title_signUp = new JLabel("Create a new account here");
            _title_createDone = new JLabel("You've successfully created an account!");
            _title_passwordNotMatch = new JLabel("Your password doesn't match. Please enter it again!");
        }

        {
            _textField_username = new JTextField(16);
            _passwordField_password = new JPasswordField(16);
            _passwordField_passwordConfirm = new JPasswordField(16);
        }

        {
            _panel_0 = new JPanel();
            _panel_1 = new JPanel();
            _panel_2 = new JPanel();
            _panel_3 = new JPanel();
            _panel_4 = new JPanel();
            _panel_5 = new JPanel();
            _panel_6 = new JPanel();
            _panel_7 = new JPanel();

            _panel_0.add(_title_signUp);
            _panel_1.add(_title_username);
            _panel_1.add(_textField_username);
            _panel_2.add(_title_password);
            _panel_2.add(_passwordField_password);
            _panel_3.add(_title_passwordConfirm);
            _panel_3.add(_passwordField_passwordConfirm);
            _panel_4.add(_button_creatAccount);
            _panel_5.add(_title_createDone);
            _panel_5.setVisible(false);
            _panel_5.add(_button_signIn);
            _panel_5.setVisible(false);
            _panel_6.add(_title_passwordNotMatch);
            _panel_6.setVisible(false);
            _panel_7.add(_button_previous);

        }

        {
            this.add(_panel_0);
            this.add(_panel_1);
            this.add(_panel_2);
            this.add(_panel_3);
            this.add(_panel_4);
            this.add(_panel_5);
            this.add(_panel_6);
            this.add(_panel_6);
            this.add(_panel_7);
        }

        {
            this.setLayout(new GridLayout(8, 1));
            this.setTitle("Sign Up");
            this.setSize(400, 300);
            this.setLocation(400, 300);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);
        }
    }


    public void actionPerformed(ActionEvent e) {
        String pw1 = new String(_passwordField_password.getPassword());
        String pw2 = new String(_passwordField_passwordConfirm.getPassword());
        String name = _textField_username.getText();
        if (e.getActionCommand().equals("Sign up")) {
            if (pw1.equals(pw2) && !pw1.equals("") && !pw2.equals("")) {
                UserInfo userInfo = new UserInfo(-1, name, pw2, null);

                _panel_6.setVisible(false);
                _panel_5.setVisible(true);
                SQLHelper.insertUserInfo(userInfo);
                _button_signIn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == _button_signIn) {
                            dispose();
                            new UILogin();
                        }
                    }
                });
            } else {
                _panel_5.setVisible(false);
                _panel_6.setVisible(true);
            }
        } else if (e.getActionCommand().equals("Previous")) {
            dispose();
            new UILogin();
        }
    }
}