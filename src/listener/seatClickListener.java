package listener;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import lib.Seat;

public class seatClickListener implements MouseListener {
	Seat s;
	JFrame thisJFrame;
	JLabel seat;
	int[] selectNum;
	public seatClickListener(Seat s, JLabel seat, JFrame thisJFrame, int[] selectNum) {
		this.s=s;
		this.thisJFrame=thisJFrame;
		this.seat=seat;
		this.selectNum=selectNum;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(s.isBooked())
			return;
		else{
			if(s.isEmpty()){
				s=Seat.CHOSEN;
				seat.setBackground(Color.yellow);
				seat.repaint();
				selectNum[0]++;
			}else{
				if(s.isChosen()){
					s=Seat.EMPTY;
					seat.setBackground(Color.white);
					seat.repaint();
					selectNum[0]--;
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
