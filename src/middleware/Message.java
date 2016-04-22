package middleware;

import java.io.Serializable;

public class Message implements Serializable {

	private static final long serialVersionUID = 5556867058938467437L;

	private Operation operation;
	
	private Object value;

	public Message(Operation operation, Object value) {
		super();
		this.operation = operation;
		this.value = value;
	}
	
	public boolean equals(Message msg){
		return this.operation == msg.operation && this.value.equals(msg.value);
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
}
