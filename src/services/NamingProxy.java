package services;

import java.io.IOException;
import java.net.UnknownHostException;

import middleware.ClientProxy;
import middleware.Requestor;
import middleware.wrapper.Invocation;

public class NamingProxy extends ClientProxy{
	
	private static final long serialVersionUID = -8963214206719992299L;

	public NamingProxy(int port){
		super(port);
	}

	public NamingProxy(String host, int port) {
		super(host, port);
	}

	public void bind(String name, ClientProxy proxy) throws UnknownHostException, ClassNotFoundException, IOException{
		
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		
		Invocation invocation = new Invocation();
		invocation.setMethod(methodName);
		invocation.addParameter(name);
		invocation.addParameter(proxy);
		invocation.setHost(this.getHost());
		invocation.setPort(this.getPort());
		invocation.setObjectId(this.getObjectId());
		
		Requestor.invoke(invocation);
		
	}

	public ClientProxy lookup(String name) throws UnknownHostException, ClassNotFoundException, IOException {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		
		Invocation invocation = new Invocation();
		invocation.setMethod(methodName);
		invocation.addParameter(name);
		invocation.setHost(this.getHost());
		invocation.setPort(this.getPort());
		invocation.setObjectId(this.getObjectId());
		
		return (ClientProxy) Requestor.invoke(invocation);
	}
	
}
