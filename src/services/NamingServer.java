package services;

import java.io.IOException;


public class NamingServer {

	public static void main(String[] args) throws ClassNotFoundException, IOException{
		System.out.println("Running Naming server...");
		NamingInvoker.invoke(12345);
		
	}
	
}
