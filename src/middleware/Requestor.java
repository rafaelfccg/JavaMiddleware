package middleware;

import java.io.IOException;
import java.net.UnknownHostException;

import middleware.wrapper.Invocation;

public class Requestor {

	public static Object invoke(Invocation invocation) throws UnknownHostException, IOException, ClassNotFoundException{
		ClientRequestHandler handler = new ClientRequestHandler(invocation.getHost(), invocation.getPort());
		
		Message request = new Message();
		request.setMethod(invocation.getMethod());
		request.setParameters(invocation.getParameters());
		request.setObjectId(invocation.getObjectId());
		
		byte[] requestBytes = Marshaller.marshall(request);
		handler.send(requestBytes);
		
		Message response = Marshaller.unmarshall(handler.receive());
		
		return response.getResult();
	}
	
}
