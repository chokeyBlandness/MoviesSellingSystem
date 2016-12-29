package window;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import lib.Screening;
import lib.SellingSystem;
import login.Client;
import login.LoginInterface;

public class PayDialog extends JDialog{
	PayDialog thisDialog =this;
	Screening screening;
	SellingSystem system;
	int [] selectNum;
	public PayDialog(Screening screening, int[] selectNum,SellingSystem system){
		this.system=system;
		this.screening=screening;
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("支付页面");
		this.selectNum=selectNum;
		this.setBounds(200,300,200,260);
		addContains();
		addMenu();
	}

	private void addContains() {
		JTextArea information =new JTextArea();
		information.setEditable(false);
		information.setText("  电影："+screening.getFilm().getName()+"\r\n"
				+"  地点: "+screening.getStudio().getName()+"\r\n"
				+"  时间: "+screening.getTime()+"\r\n"
				+"  数量: "+selectNum[0]+"\r\n"
				);
		JButton pay =new JButton("付款");
		pay.addActionListener(e ->thisDialog.dispose());
		this.getContentPane().add(information, "Center");
		this.getContentPane().add(pay, "South");
		
	}
	
	private void addMenu() {
		JMenuBar main = new JMenuBar();
		this.setJMenuBar(main);
		JMenu menu= new JMenu("menu");
		main.add(menu);
		
		JMenuItem loginMenu=new JMenuItem("login");
		//登录功能
		loginMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginInterface loginInterface=new LoginInterface(system);
				loginInterface.setVisible(true);
			}
		}
		);
		
		JMenuItem snackMenu=new JMenuItem("snack");
		//零食功能
		
		menu.add(loginMenu);
		menu.add(snackMenu);
	}
}
