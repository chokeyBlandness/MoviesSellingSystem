package login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import lib.SellingSystem;

public class LoginInterface extends JFrame {
	LoginInterface loginInterface = this;
	JTextField accountText = new JTextField();
	JPasswordField password = new JPasswordField();
	SellingSystem system;

	public LoginInterface(SellingSystem system) {
		this.system=system;
		this.setTitle("logining");
		this.setBounds(300, 200, 400, 300);
		this.setLayout(new BorderLayout());
		addAccount();
		addPassword();
		addLoginButton();
	}

	private void addAccount() {
		JPanel accountPanel = new JPanel();
		accountPanel.setBounds(0, 0, 200, 150);
		accountPanel.setLayout(null);
//		accountPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JLabel accountLabel = new JLabel("account");
		accountLabel.setBounds(10, 10, 80, 20);

		accountText.setHorizontalAlignment(JTextField.CENTER);
		accountText.setBounds(50, 50, 100, 40);

		accountPanel.add(accountLabel);
		accountPanel.add(accountText);
		getContentPane().add(accountPanel);
	}

	private void addPassword() {
		JPanel passwordPanel = new JPanel();
		passwordPanel.setBounds(0, 150, 200, 150);
		passwordPanel.setLayout(null);
//		passwordPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JLabel passwordLabel = new JLabel("password");
		passwordLabel.setBounds(10, 10, 80, 20);

		password.setBounds(50, 50, 100, 40);

		passwordPanel.add(passwordLabel);
		passwordPanel.add(password);
		getContentPane().add(passwordPanel);
	}

	private void addLoginButton() {
		JPanel buttonPanel = new JPanel();
//		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		buttonPanel.setBounds(200, 300, 50, 50);
		buttonPanel.setLayout(null);
		JButton loginButton = new JButton("login in");
		loginButton.setBounds(250, 150, 100, 50);
		loginButton.addMouseListener(new LoginListener(accountText, password,system, loginInterface));
		buttonPanel.add(loginButton, "Center");
		getContentPane().add(buttonPanel);
	}
}