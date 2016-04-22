package middleware;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerRequestHandler {

	private int port;
	private ServerSocket serverSocket;
	private Socket socket;
	private DataOutputStream output;
	private DataInputStream input;
	
	public ServerRequestHandler(int port) throws IOException {
		super();
		this.port = port;
	}
	
	public void send(byte[] bytes) throws IOException{
		this.output.writeInt(bytes.length);
		this.output.write(bytes);
		this.serverSocket.close();
		this.socket.close();
	}
	
	public byte[] receive() throws IOException{
		this.serverSocket = new ServerSocket(port);
		this.socket = serverSocket.accept();
		this.output = new DataOutputStream(socket.getOutputStream());
		this.input = new DataInputStream(socket.getInputStream());
		int length = this.input.readInt();
		byte[] message = new byte[length];
		this.input.readFully(message);
		return message;
	}
	
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public ServerSocket getServerSocket() {
		return serverSocket;
	}

	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public DataOutputStream getOutput() {
		return output;
	}

	public void setOutput(DataOutputStream output) {
		this.output = output;
	}

	public DataInputStream getInput() {
		return input;
	}

	public void setInput(DataInputStream input) {
		this.input = input;
	}

}
