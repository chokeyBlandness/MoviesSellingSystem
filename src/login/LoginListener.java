package login;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import lib.SellingSystem;

public class LoginListener implements MouseListener {
	LoginInterface loginInterface;
	JTextField accountText;
	JPasswordField password;
	SellingSystem system;

	public LoginListener(JTextField accountText, JPasswordField password,
			SellingSystem system, LoginInterface loginInterface) {
		// TODO Auto-generated constructor stub
		this.system= system;
		this.accountText = accountText;
		this.password = password;
		this.loginInterface = loginInterface;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		try {
			Client client = new Client(accountText.getText(), 
					String.valueOf(password.getPassword()),
					system, loginInterface);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
