package middleware.wrapper;

import java.util.ArrayList;

public class Invocation {

	private String host;
	private int port;
	private int objectId;
	private String method;
	private ArrayList<Object> parameters;
	
	public Invocation() {
		super();
		parameters = new ArrayList<Object>();
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
	
	public String getMethod() {
		return method;
	}
	
	public void setMethod(String method) {
		this.method = method;
	}
	
	public ArrayList<Object> getParameters() {
		return parameters;
	}
	
	public void setParameters(ArrayList<Object> parameters) {
		this.parameters = parameters;
	}
	
	public void addParameter(Object parameter){
		this.parameters.add(parameter);
	}
	
}
