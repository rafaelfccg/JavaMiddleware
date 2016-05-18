package middleware;

import java.io.Serializable;
import java.util.ArrayList;

public class Message implements Serializable {

	private static final long serialVersionUID = -7370558527041566902L;
	
	private int objectId;

	private String method;
	
	private ArrayList<Object> parameters;
	
	private Object result;

	public Message() {
		super();
	}

	public Message(String operation, ArrayList<Object> parameters) {
		super();
		this.method = operation;
		this.parameters = parameters;
	}

	public Message(Object result) {
		super();
		this.result = result;
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

	public void setMethod(String operation) {
		this.method = operation;
	}

	public ArrayList<Object> getParameters() {
		return parameters;
	}

	public void setParameters(ArrayList<Object> parameters) {
		this.parameters = parameters;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
	
}
