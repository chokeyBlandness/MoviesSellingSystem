package window;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import lib.SellingSystem;
import lib.Studio;
import listener.FilmClickListener;
import listener.StudioClickListener;

public class StudioArea extends JPanel {
	SellingSystem system;
	Window window;
	StudioArea(SellingSystem system, Window window){
		this.system=system;
		this.window =window;
		this.setPreferredSize(new Dimension(200, 1000));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		addContains();
	}
	
	private void addContains() {
		for(Studio studio:system.allStudioSet){
			JLabel label = new JLabel();
			label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			label.setPreferredSize(new Dimension(180, 30));
			label.setText(studio.getName());
			label.addMouseListener(new StudioClickListener(system,window,studio));
			this.add(label,"North");
		}
	}
	
}
