package server;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

import client.TextProcessingProxy;
import services.NamingProxy;

public class Server {

	private static Scanner in;

	public static void main(String[] args) throws UnknownHostException, ClassNotFoundException, IOException{
		
		NamingProxy namingProxy = new NamingProxy("localhost", 12345);
		
		TextProcessingProxy textProcessing = new TextProcessingProxy(2323);
		in = new Scanner(System.in); 
		System.out.println("Input the wanted object Id:");
		textProcessing.setObjectId(in.nextInt());
		System.out.println("Input the name of the service");
		System.out.println("will bind object with host"+ textProcessing.getHost());
		namingProxy.bind(in.next(), textProcessing);
		
		System.out.println("Running server...");
		TextProcessingInvoker.invoke(textProcessing);
		
	}
	
}
