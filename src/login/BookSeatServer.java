package login;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import lib.SellingSystem;
import lib.Seat;

public class BookSeatServer implements Runnable {
	int bookSeatPort;
	SellingSystem system;
	public BookSeatServer(int bookSeatPort, SellingSystem system) {
		this.bookSeatPort=bookSeatPort;
		this.system=system;
	}

	@Override
	public void run() {
		try {
			DatagramSocket socket =new DatagramSocket(bookSeatPort);
			while(true){
				byte[] accountBuffer =new byte[2000];
				DatagramPacket accountPacket =new DatagramPacket(accountBuffer, accountBuffer.length);
				socket.receive(accountPacket);
				
				byte[] screeningBuffer =new byte[2000];
				DatagramPacket screeningPacket =new DatagramPacket(screeningBuffer, screeningBuffer.length);
				socket.receive(screeningPacket);
				
				Thread SetSeatServer =new Thread(new SetSeatServer(accountPacket,screeningPacket,socket,system));
				SetSeatServer.start();
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
