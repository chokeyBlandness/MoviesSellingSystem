package window;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SnakckWindow extends JFrame {
	public SnakckWindow(){
		this.setResizable(false);
		this.setTitle("零食买买买！");
		this.setBounds(200,100, 500,500);
		this.setVisible(true);
		addFood();
		
	}

	private void addFood() {
		JPanel panel=new JPanel();
		panel.setPreferredSize(new Dimension(500,1060));
		FlowLayout layout=new FlowLayout();
		layout.setHgap(10);
		layout.setVgap(10);
		panel.setLayout(layout);
		JScrollPane scrollPane=new JScrollPane(panel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setWheelScrollingEnabled(true);
		this.getContentPane().add(scrollPane);
		JCheckBox [] box=new JCheckBox[5];
		box[0]=new JCheckBox("瓜子");
		box[1]=new JCheckBox("辣条");
		box[2]=new JCheckBox("啤酒");
		box[3]=new JCheckBox("花生米");
		box[4]=new JCheckBox("八宝粥");
		JButton [] button=new JButton[5];
		for(int i=0;i<5;i++){
			button[i]=new JButton();
			button[i].setEnabled(false);
//			button[i].setBorderPainted(false);
			button[i].add(box[i]);
			button[i].setPreferredSize(new Dimension(300,60));
			panel.add(button[i]);
		}
		
		
	}
}
