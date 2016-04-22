package test;

import java.io.IOException;

import middleware.Marshaller;
import middleware.Message;
import middleware.Operation;

public class MarshallerTest {

	public static void main(String[] args){
				
		try {
			Message before = new Message(Operation.Echo, "Teste");
			Message after = Marshaller.unmarshall(Marshaller.marshall(before));
			System.out.println(before.equals(after));

		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
