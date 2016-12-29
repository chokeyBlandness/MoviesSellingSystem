package window;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import lib.Screening;
import lib.SellingSystem;
import listener.ScreeningClickListener;
import listener.WindowCloseListener;

public class SelectScreeningWindow extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SellingSystem system;
	JFrame lastJFrame;
	JFrame thisJFrame=this;
	public SelectScreeningWindow(SellingSystem system, JFrame lastJFrame) {
		this.system=system;
		this.lastJFrame =lastJFrame;
		this.setBounds(lastJFrame.getBounds());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.addWindowListener(new WindowCloseListener(lastJFrame,thisJFrame,system));
		addContains();
	}
	private void addContains() {
		JPanel panel = new JPanel();
		JScrollPane js =new JScrollPane(panel);
		panel.setPreferredSize(lastJFrame.getSize());
		
		ArrayList<Screening> list;
		list=system.showScreening();
		for(Screening screening:list){
			JLabel label = new JLabel();
			label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			label.setPreferredSize(new Dimension(490, 150));
			label.setText(screening.getTime());
			label.addMouseListener(new ScreeningClickListener(system,thisJFrame,screening));
			panel.add(label,"North");
		}
		
		this.getContentPane().add(js);
		
	}

}
