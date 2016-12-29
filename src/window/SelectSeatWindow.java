package window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import exception.BookFaildException;
import exception.BookSuccessException;
import lib.Screening;
import lib.Seat;
import lib.SellingSystem;
import listener.WindowCloseListener;
import listener.seatClickListener;
import login.Client;
import login.LoginInterface;

public class SelectSeatWindow extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame lastJFrame;
	JFrame thisJFrame=this;
	Screening screening;
	SellingSystem system;
	int[] selectNum;
	public SelectSeatWindow(JFrame lastJFrame, Screening screening, SellingSystem system) {
		this.lastJFrame =lastJFrame;
		this.screening =screening;
		this.system=system;
		selectNum =new int[1];
		this.setBounds(lastJFrame.getBounds());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.addWindowListener(new WindowCloseListener(lastJFrame,thisJFrame,system));
		addContains();
	}
	
	private void addContains() {
		JPanel pane = new JPanel();
		
		JPanel seatArea = setSeatArea();
		pane.add(seatArea);
		
		JButton buy = new JButton("¹ºÂò");
		buy.setPreferredSize(new Dimension(80, 40));
		buy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(system.account.accountNumber==null){
						LoginInterface loginInterface=new LoginInterface(system);
						loginInterface.setVisible(true);
					}
					else{
						Client bookSeat = new Client("bookSeat", system.account, screening);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BookSuccessException e) {
					PayDialog pd =new PayDialog(screening,selectNum,system);
					pd.setVisible(true);
				} catch (BookFaildException e) {
					JOptionPane.showMessageDialog(null, "×ùÎ»ÒÑ±»Ô¤¶© ");
					//TODO
					//refresh
					
				}
			}
		});
		pane.add(buy,"South");
		
		JButton snack =new JButton("ÌíµãÁãÊ³°¡~");
		snack.addActionListener(e ->{
			SnakckWindow s = new SnakckWindow();
		});
		pane.add(snack,"South");	
		
		this.getContentPane().add(pane);
	}

	private JPanel setSeatArea() {
		JPanel seatArea =new JPanel();
		GridLayout gly = new GridLayout(10, 10);
		gly.setHgap(5);
		gly.setVgap(5);
		seatArea.setLayout(gly);
		
		seatArea.setPreferredSize(new Dimension((int)(this.getWidth()*0.6)
				,(int)(this.getHeight()*0.6)));

		
		Seat[] seats =screening.getSeat();
		for(Seat s:seats){
			JLabel seat = new JLabel();
			seat.setPreferredSize(new Dimension(30, 30));
			seat.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			seat.setOpaque(true);
			seat.addMouseListener(new seatClickListener(s,seat,thisJFrame,selectNum));
			setSolor(seat,s);
			seatArea.add(seat);
		}
		return seatArea;
	}


	private void setSolor(JLabel seat, Seat s) {
		if(s.isEmpty())
			seat.setBackground(Color.white);
		if(s.isBooked())
			seat.setBackground(Color.DARK_GRAY);
		if(s.isChosen())
			seat.setBackground(Color.yellow);
	}
	
}
