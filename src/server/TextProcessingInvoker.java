package server;

import java.io.IOException;
import java.util.HashMap;

import middleware.Marshaller;
import middleware.Message;
import middleware.ServerRequestHandler;

public class TextProcessingInvoker {

	private int port;

	private HashMap<Integer, TextProcessing> remoteObjects;

	public TextProcessingInvoker(int port) {
		this.port = port;
		this.remoteObjects = new HashMap<Integer, TextProcessing>();
	}

	public void invoke() throws IOException, ClassNotFoundException{
		ServerRequestHandler handler = new ServerRequestHandler(this.port);

		while(true){

			Message request = Marshaller.unmarshall(handler.receive());

			// Create remote object at runtime if not created
			if(!this.remoteObjects.containsKey(request.getObjectId()))
				this.remoteObjects.put(request.getObjectId(), new TextProcessing());

			TextProcessing implementation = this.remoteObjects.get(request.getObjectId());
			//call function for the received method
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

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public HashMap<Integer, TextProcessing> getRemoteObjects() {
		return remoteObjects;
	}


	public void setRemoteObjects(HashMap<Integer, TextProcessing> remoteObjects) {
		this.remoteObjects = remoteObjects;
	}
}