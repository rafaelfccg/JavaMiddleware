package middleware;

import java.io.Serializable;

public class ClientProxy implements Serializable{
	//Our ClientProxy is our AOR, for this simple middleware it will have only host ip, port and object id
	private static final long serialVersionUID = -3477041465520026576L;
	
	protected String host;
	protected int port;
	protected int objectId;

	public ClientProxy() {
		super();
	}

	public ClientProxy(int port) {
		this("localhost", port);
	}

	public ClientProxy(String host, int port) {
		super();
		this.host = host;
		this.port = port;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getObjectId() {
		return objectId;
	}

	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}
	
	
}
