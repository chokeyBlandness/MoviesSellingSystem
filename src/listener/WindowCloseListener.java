package listener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import lib.SellingSystem;
import window.SelectStudioWindow;
import window.Window;

public class WindowCloseListener implements WindowListener {
	JFrame lastJFrame;
	JFrame thisJFrame;
	protected SellingSystem system;
	public WindowCloseListener(JFrame lastJFrame,JFrame thisJFrame, SellingSystem system) {
		this.lastJFrame =lastJFrame;
		this.thisJFrame=thisJFrame;
		this.system=system;
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		

	}

	@Override
	public void windowClosing(WindowEvent e) {
		lastJFrame.setBounds(thisJFrame.getBounds());
		lastJFrame.setVisible(true);

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
