package services;

import java.io.IOException;

import middleware.ClientProxy;
import middleware.Marshaller;
import middleware.Message;
import middleware.ServerRequestHandler;
import server.TextProcessing;

public class NamingInvoker {

	public static void invoke(int port) throws IOException, ClassNotFoundException{
		ServerRequestHandler handler = new ServerRequestHandler(port);
		
		NamingService implementation = new NamingService();
		
		while(true){
			
			Message request = Marshaller.unmarshall(handler.receive());
			
			String method = request.getMethod();
			
			if(method.equals("bind")){
				String name = (String) request.getParameters().get(0);
				ClientProxy clientProxy = (ClientProxy) request.getParameters().get(1);
				implementation.bind(name, clientProxy);
				
				Message response = new Message();
				
				handler.send(Marshaller.marshall(response));
			}else if(method.equals("lookup")){
				String name = (String) request.getParameters().get(0);

				ClientProxy proxy = implementation.lookup(name);
				
				Message response = new Message();
				response.setResult(proxy);
				
				handler.send(Marshaller.marshall(response));
			}

		}
		
	}
	
}
