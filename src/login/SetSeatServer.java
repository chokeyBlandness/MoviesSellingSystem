package login;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import exception.SeatHaveBeenBookedException;
import exception.SetSeatSuccessException;
import lib.Screening;
import lib.SellingSystem;
import lib.Seat;

public class SetSeatServer implements Runnable {
	DatagramPacket accountPacket;
	DatagramPacket screeningPacket;
	DatagramSocket socket;
	SellingSystem system;
	public SetSeatServer(DatagramPacket accountPacket, DatagramPacket screeningPacket,
			DatagramSocket socket, SellingSystem system) {
		this.accountPacket=accountPacket;
		this.screeningPacket=screeningPacket;
		this.socket=socket;
		this.system=system;
	}

	@Override
	public void run() {
		ByteArrayInputStream bos = new ByteArrayInputStream(screeningPacket.getData());
		try {
			ObjectInputStream in = new ObjectInputStream(bos);
			Screening screening = (Screening)in.readObject();
			Screening screeningOfsystem=system.searchScreening(screening);
			screeningOfsystem.setSeat(screening.getSeat());
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SeatHaveBeenBookedException e) {
			byte[] errorBuffer ="false".getBytes();
			DatagramPacket error = new DatagramPacket(errorBuffer, errorBuffer.length,
					accountPacket.getAddress(),accountPacket.getPort());
			try {
				socket.send(error);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (SetSeatSuccessException e) {
			byte[] errorBuffer ="true".getBytes();
			DatagramPacket error = new DatagramPacket(errorBuffer, errorBuffer.length,
					accountPacket.getAddress(),accountPacket.getPort());
			try {
				socket.send(error);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
