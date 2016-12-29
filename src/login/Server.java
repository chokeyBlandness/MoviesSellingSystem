package login;

import java.io.IOException;

import lib.SellingSystem;


public class Server {
	static int logInNumber=1685;
	static int bookSeatPort = 1851;
	public static void main(String[] args) throws IOException{
		SellingSystem system =new SellingSystem();
		
		Thread loginServer =new Thread(new LoginServer(logInNumber));
		loginServer.start();
		Thread bookSeatServer =new Thread(new BookSeatServer(bookSeatPort,system));
		bookSeatServer.start();
	}
}
