package window;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import lib.Film;
import lib.SellingSystem;
import listener.FilmClickListener;

public class FilmeArea extends JPanel {
	SellingSystem system;
	Window window;
	FilmeArea(SellingSystem system, Window window){
		this.system=system;
		this.window =window;
		this.setPreferredSize(new Dimension(500, 1000));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		addContains();
	}
	
	private void addContains() {
		for(Film film:system.allFilmSet){
			JLabel label = new JLabel();
			label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			label.setPreferredSize(new Dimension(490, 150));
			label.setText(film.getName());
			label.addMouseListener(new FilmClickListener(system,window,film));
			this.add(label,"North");
		}
	}
	
}
