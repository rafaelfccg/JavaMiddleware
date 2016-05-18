package client;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

import services.NamingProxy;

public class Client {

	private static Scanner in;

	public static void main(String[] args) throws UnknownHostException, ClassNotFoundException, IOException{
		
		NamingProxy namingProxy = new NamingProxy("localhost", 12345);
		
		TextProcessingProxy test = (TextProcessingProxy) namingProxy.lookup("textp2");
		System.out.print(test.getObjectId());
		in = new Scanner(System.in);
		while(true){
			String input = in.nextLine();
			System.out.println("Number of words:"+test.countWords(input));
		}
		
	}
	
}
