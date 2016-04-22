package client;

import java.io.IOException;
import java.util.Scanner;

import middleware.ClientRequestHandler;
import middleware.Marshaller;
import middleware.Message;
import middleware.Operation;
import util.Logger;

public class Echo {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);;
		try {
			
			while(true){
				
				String userMessage = scanner.nextLine();
				
				ClientRequestHandler handler = new ClientRequestHandler("127.0.0.1", 12345);
				
				Message msg = new Message(Operation.Echo, userMessage);
				
				Logger.log("Sending request with string " + msg.getValue().toString());
				
				handler.send(Marshaller.marshall(msg));
				
				Message response = Marshaller.unmarshall(handler.receive());
				
				Logger.log("Received response with string " + response.getValue().toString());
			}
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			scanner.close();
		}
		
	}
	
}
