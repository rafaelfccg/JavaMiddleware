package server;

import java.io.IOException;

import middleware.Marshaller;
import middleware.Message;
import middleware.Operation;
import middleware.ServerRequestHandler;
import util.Logger;

public class EchoServer {

	public static void main(String[] args){
		
		while(true){
			
			try {
				ServerRequestHandler handler = new ServerRequestHandler(12345);
				
				Message request = Marshaller.unmarshall(handler.receive());
				
				Logger.log("Received request with string " + request.getValue().toString());
				
				Message response = new Message(Operation.Response, request.getValue());
				
				handler.send(Marshaller.marshall(response));
				
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}
	
}
