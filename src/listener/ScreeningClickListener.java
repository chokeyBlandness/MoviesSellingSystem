package listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import lib.Screening;
import lib.SellingSystem;
import window.SelectSeatWindow;

public class ScreeningClickListener implements MouseListener {
	SellingSystem system;
	JFrame lastJFrame;
	Screening screening;
	
	public ScreeningClickListener(SellingSystem system, JFrame lastJFrame, Screening screening) {
		this.system=system;
		this.lastJFrame =lastJFrame;
		this.screening=screening;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		lastJFrame.setVisible(false);
		SelectSeatWindow ss = new SelectSeatWindow(lastJFrame,screening,system);
		ss.setVisible(true);

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
