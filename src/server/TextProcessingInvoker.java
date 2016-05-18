package server;

import java.io.IOException;

import middleware.ClientProxy;
import middleware.Marshaller;
import middleware.Message;
import middleware.ServerRequestHandler;

public class TextProcessingInvoker {

	public static void invoke(ClientProxy proxy) throws IOException, ClassNotFoundException{
		ServerRequestHandler handler = new ServerRequestHandler(proxy.getPort());
		
		TextProcessing implementation = new TextProcessing();
		
		while(true){
			
			Message request = Marshaller.unmarshall(handler.receive());
			
			switch(request.getMethod()){
				case "countWords":
					String text = (String) request.getParameters().get(0);
					Integer result = implementation.countWords(text);
					
					Message response = new Message();
					response.setResult(result);
					
					handler.send(Marshaller.marshall(response));
					
					break;
				
			}
			
		}
		
	}
	
}
