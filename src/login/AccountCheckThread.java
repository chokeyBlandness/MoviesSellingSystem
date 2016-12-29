package login;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import lib.SellingSystem;

public class AccountCheckThread implements Runnable{
	DatagramPacket inAccpacket;
	DatagramPacket inPasspacket;
	DatagramSocket socket;
	public AccountCheckThread(DatagramPacket inAccpacket,DatagramPacket inPasspacket,DatagramSocket socket){
		this.inAccpacket=inAccpacket;
		this.inPasspacket=inPasspacket;
		this.socket=socket;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String inAcc=new String(inAccpacket.getData()).trim();
		String inPass=new String(inPasspacket.getData()).trim();
		
		byte[] outByte=new byte[2000];
		outByte =String.valueOf(judge(inAcc,inPass)).getBytes();
		DatagramPacket outPacket=new DatagramPacket(outByte,outByte.length,inAccpacket.getAddress(),inAccpacket.getPort());
		try {
			socket.send(outPacket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	private boolean judge(String inAcc, String inPass) {
		LoginSystem loginSystem=new LoginSystem();
		Account searchAcc=null;
		for(Account acc:loginSystem.account){
			if(acc.accountNumber.equals(inAcc)){
				searchAcc=acc;
			}
		}
		if(searchAcc==null){
			System.out.println("no such account");
			return false;
		}
		else{
			if(searchAcc.password.equals(inPass)){
				SellingSystem system=new SellingSystem();
				system.account=searchAcc;
				return true;
			}
			else {
				System.out.println("wrong password");
				return false;
			}
		}
	}
}

