package server;

public class TextProcessing {
	//class implementation
	public int countWords(String text){
		if (text.isEmpty())
	        return 0;
	    return text.split("\\s+").length; 
	}
	
}
