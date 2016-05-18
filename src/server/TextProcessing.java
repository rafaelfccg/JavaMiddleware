package server;

public class TextProcessing {

	public int countWords(String text){
		if (text.isEmpty())
	        return 0;
	    return text.split("\\s+").length; 
	}
	
}
