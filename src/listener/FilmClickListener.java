package listener;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import window.SelectScreeningWindow;
import window.SelectStudioWindow;
import window.Window;

import lib.Film;
import lib.SellingSystem;

public class FilmClickListener implements MouseListener {
	SellingSystem system;
	JFrame lastJFrame;
	Film film;
	public FilmClickListener(SellingSystem system, JFrame lastJFrame, Film film) {
		this.system=system;
		this.lastJFrame =lastJFrame;
		this.film=film;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		system.setSerachFilm(film);
		lastJFrame.setVisible(false);
		if(system.isSelectFinish()){
			SelectScreeningWindow ss = new SelectScreeningWindow(system,lastJFrame);
			ss.setVisible(true);
		}else{
			SelectStudioWindow sw = new SelectStudioWindow(system,lastJFrame);
			sw.setVisible(true);
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
