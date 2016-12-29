package login;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import exception.BookFaildException;
import exception.BookSuccessException;
import lib.Screening;
import lib.SellingSystem;

public  class Client {
	int logInNumber=1685;
	int bookSeatPort = 1851;
	InetAddress localAddress;
	DatagramSocket socket;
	SellingSystem system;
	public Client(String account,String password,SellingSystem system,LoginInterface loginInterface) throws Exception{
		this.system=system;
		localAddress = InetAddress.getLocalHost();
		socket =new DatagramSocket();
		byte[] outAcc=account.getBytes();
		byte[] outPass=password.getBytes();
		
		DatagramPacket outAccPacket=new DatagramPacket(outAcc,outAcc.length,localAddress,logInNumber);
		DatagramPacket outPassPacket=new DatagramPacket(outPass,outPass.length,localAddress,logInNumber);
		socket.send(outAccPacket);
		socket.send(outPassPacket);
		
		byte[] buf = new byte[2000];
		DatagramPacket packet = new DatagramPacket(buf,buf.length);
		socket.receive(packet);
		String judge=new String(packet.getData()).trim();
		if(judge.equals("false")){
				loginInterface.dispose();
				LoginInterface li=new LoginInterface(system);
				li.setVisible(true);
			}
		else{
			system.setAccount(account);
			loginInterface.dispose();
		}
		socket.close();
	}
	
	public Client(String bookSeat,Account account,Screening editedScreening) throws IOException, ClassNotFoundException
		, BookSuccessException, BookFaildException{
		socket =new DatagramSocket();
		localAddress = InetAddress.getLocalHost();
		
		byte[] outBuffer =new byte[1000];
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(bos);
		out.writeObject(editedScreening);
		out.flush();
		outBuffer = bos.toByteArray();
		
		socket.send(outPacket(account.accountNumber));
		socket.send(outPacket(outBuffer));
		
		byte[] inBuffer =new byte[1000];
		DatagramPacket inPacket =new DatagramPacket(inBuffer, inBuffer.length);
		socket.receive(inPacket);
		String result =new String(inPacket.getData()).trim();
		if(result.equals("true"))
			throw new BookSuccessException();
		else if(result.equals("false"))
			throw new BookFaildException();
		
	}
	private DatagramPacket outPacket(byte[] byteArray) {
		DatagramPacket outPacket=new DatagramPacket(byteArray,byteArray.length,
				localAddress,bookSeatPort);
		return outPacket;
	}
	private DatagramPacket outPacket(String contains) {
		byte[] outContains = contains.getBytes();
		DatagramPacket outPacket=new DatagramPacket(outContains,outContains.length,
				localAddress,bookSeatPort);
		return outPacket;
	}
}
