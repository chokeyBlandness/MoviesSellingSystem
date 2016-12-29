package listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import lib.Film;
import lib.SellingSystem;
import lib.Studio;
import window.SelectFilmWindow;
import window.SelectScreeningWindow;
import window.SelectStudioWindow;
import window.Window;

public class StudioClickListener implements MouseListener {
	SellingSystem system;
	JFrame lastJFrame;
	Studio studio;
	public StudioClickListener(SellingSystem system, JFrame lastJFrame, Studio studio) {
		this.system=system;
		this.lastJFrame =lastJFrame;
		this.studio=studio;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		system.setSerachStudio(studio);
		lastJFrame.setVisible(false);
		if(system.isSelectFinish()){
			SelectScreeningWindow ss = new SelectScreeningWindow(system,lastJFrame);
			ss.setVisible(true);
		}else{
			SelectFilmWindow sf = new SelectFilmWindow(system,lastJFrame);
			sf.setVisible(true);
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
