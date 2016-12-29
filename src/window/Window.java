package window;

import lib.*;
import login.Client;
import login.LoginInterface;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Window extends JFrame {
	SellingSystem system;
	Container mainPane;
	Window window;
	Window(){
		window = this;
		system = new SellingSystem();
		this.setTitle("买电影票票票！");
		this.setBounds(200, 100, 800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainPane = this.getContentPane();
		mainPane.setLayout(new BorderLayout());
		addMenu();
		addSplitPane();
		
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
		
		
		menu.add(loginMenu);
	}
	
	private void addSplitPane() {
		JSplitPane js = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		StudioArea sa =new StudioArea(system,window);
		JScrollPane jscs = new  JScrollPane(sa);
		js.setLeftComponent(jscs);
		FilmeArea fa =new FilmeArea(system,window);
		JScrollPane jscf = new  JScrollPane(fa);
		js.setRightComponent(jscf);
		mainPane.add(js);
		
	}




	public static void main(String[] args)  {
		UIManager m =new UIManager();
		String lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
		try {
			m.setLookAndFeel(lookAndFeel);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Window window =new Window();
		window.setVisible(true);
	}
}
