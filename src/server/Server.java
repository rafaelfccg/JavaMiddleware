package server;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

import client.TextProcessingProxy;
import services.NamingProxy;

public class Server {

	private static Scanner in;

	public static void main(String[] args) throws UnknownHostException, ClassNotFoundException, IOException{
		//create invoker
		TextProcessingInvoker invoker = new TextProcessingInvoker(2323);
		
		NamingProxy namingProxy = new NamingProxy("localhost", 12345);
		//create proxy with given port number
		TextProcessingProxy textProcessing = new TextProcessingProxy(2323);
		in = new Scanner(System.in); 
		System.out.println("Input the wanted object Id:");
		textProcessing.setObjectId(in.nextInt());
		System.out.println("Input the name of object for the lookup service");
		namingProxy.bind(in.next(), textProcessing);
		//Uncomment the block bellow to test a invoker with multiple objects 
		/*/
		TextProcessingProxy textProcessing = new TextProcessingProxy(2323);
		textProcessing.setObjectId(123);
		namingProxy.bind("TextProcessing", textProcessing);
		
		TextProcessingProxy textProcessing2 = new TextProcessingProxy(2323);
		textProcessing2.setObjectId(124);
		namingProxy.bind("TextProcessing2", textProcessing2);
		
		System.out.println("Running server...");
		/**/
		
		invoker.invoke();
		
	}
	
}
