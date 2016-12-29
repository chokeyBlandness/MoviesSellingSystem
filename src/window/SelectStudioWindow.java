package window;


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import lib.Film;
import lib.Screening;
import lib.SellingSystem;
import lib.Studio;
import listener.FilmClickListener;
import listener.StudioClickListener;
import listener.WindowCloseListener;

public class SelectStudioWindow extends JFrame{
	SellingSystem system;
	JFrame lastJFrame;
	JFrame thisJFrame = this;
	public SelectStudioWindow(SellingSystem system,JFrame lastJFrame){
		this.system=system;
		this.lastJFrame =lastJFrame;
		this.setBounds(lastJFrame.getBounds());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.addWindowListener(new WindowCloseListener(lastJFrame,thisJFrame,system){
			@Override
			public void windowClosing(WindowEvent e) {
				this.system.resetFilm();
				super.windowClosing(e);
			}
			
		});
		addContains();
	}
	private void addContains() {
		JPanel panel = new JPanel();
		JScrollPane js =new JScrollPane(panel);
		panel.setPreferredSize(lastJFrame.getSize());
		
		Studio[] list;
		list=system.showStudioByFilm();
		for(Studio studio:list){
			JLabel label = new JLabel();
			label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			label.setPreferredSize(new Dimension(490, 150));
			label.setText(studio.getName());
			label.addMouseListener(new StudioClickListener(system,thisJFrame,studio));
			panel.add(label);
		}
		this.getContentPane().add(js);
	}


}
