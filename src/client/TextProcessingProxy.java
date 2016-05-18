package client;

import java.io.IOException;
import java.net.UnknownHostException;

import middleware.ClientProxy;
import middleware.Requestor;
import middleware.wrapper.Invocation;

public class TextProcessingProxy extends ClientProxy{


	private static final long serialVersionUID = -3621718057763974845L;
	
	public TextProcessingProxy(int port){
		super(port);
		
	}

	public int countWords(String text) throws UnknownHostException, ClassNotFoundException, IOException{
		
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		
		Invocation invocation = new Invocation();
		invocation.setMethod(methodName);
		invocation.addParameter(text);
		invocation.setHost(this.getHost());
		invocation.setPort(this.getPort());
		invocation.setObjectId(this.getObjectId());
	
		Object result = Requestor.invoke(invocation);
		
		return (int) result;
	}
	
}
