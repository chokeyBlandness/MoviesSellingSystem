package login;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class LoginServer implements Runnable {
	int logInNumber;
	public LoginServer(int logInNumber){
		this.logInNumber=logInNumber;
	}
	
	@Override
	public void run() {
	try {
		DatagramSocket logInSocket = new DatagramSocket(logInNumber);
		byte[] buff=new byte[2000];
		while(true){
			DatagramPacket inAccpacket=new DatagramPacket(buff,buff.length);
			logInSocket.receive(inAccpacket);
			
			DatagramPacket inPasspacket=new DatagramPacket(buff,buff.length);
			logInSocket.receive(inPasspacket);
			
			Thread thread=new Thread(new AccountCheckThread(inAccpacket,inPasspacket,logInSocket));
			thread.start();
		}
	} catch (SocketException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
}
