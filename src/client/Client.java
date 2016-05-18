package client;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

import services.NamingProxy;

public class Client {

	private static Scanner in;

	public static void main(String[] args) throws UnknownHostException, ClassNotFoundException, IOException{
		
		NamingProxy namingProxy = new NamingProxy("localhost", 12345);
		
		in = new Scanner(System.in);
		while(true){
			System.out.println("What service do you want to use?");
			TextProcessingProxy test = (TextProcessingProxy) namingProxy.lookup(in.next());
			System.out.println("Object recovered:\nobjectId: "+test.getObjectId() + "\nhost: "+test.getHost()+"\nport: "+test.getPort());
			in.nextLine();
			System.out.println("Now type a sentence and the service will count the number of words.");
			String input = in.nextLine();
			System.out.println("Number of words:"+test.countWords(input));
		}
		
		/*
		TextProcessingProxy test = (TextProcessingProxy) namingProxy.lookup("TextProcessing");
		System.out.println(test.countWords("Lorem ipsum dolot sit amet"));
		
		TextProcessingProxy test2 = (TextProcessingProxy) namingProxy.lookup("TextProcessing2");
		System.out.println(test2.countWords("Lorem ipsum"));
		*/
		
	}
	
}
