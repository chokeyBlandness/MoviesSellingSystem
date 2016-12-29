package window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import lib.Film;
import lib.SellingSystem;
import lib.Studio;
import listener.FilmClickListener;
import listener.StudioClickListener;
import listener.WindowCloseListener;

public class SelectFilmWindow extends JFrame{
	SellingSystem system;
	JFrame lastJFrame;
	JFrame thisJFrame = this;
	public SelectFilmWindow(SellingSystem system, JFrame lastJFrame) {
		this.system=system;
		this.lastJFrame =lastJFrame;
		this.setBounds(lastJFrame.getBounds());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.addWindowListener(new WindowCloseListener(lastJFrame,thisJFrame,system){
			@Override
			public void windowClosing(WindowEvent e) {
				this.system.resetStudio();
				super.windowClosing(e);
			}
			
		});
		addContains();
	}
	private void addContains() {
		JPanel pane =new JPanel();
		pane.setPreferredSize(lastJFrame.getSize());
		JScrollPane scrollPane = new  JScrollPane(pane);
		
		Film[] list;
		list=system.showFilmByStudio();
		for(Film film:list){
			JLabel label = new JLabel();
			label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			label.setPreferredSize(new Dimension(490, 150));
			label.setText(film.getName());
			label.addMouseListener(new FilmClickListener(system,thisJFrame,film));
			pane.add(label,"North");
		}
		
		this.getContentPane().add(scrollPane);
		
	}

}
