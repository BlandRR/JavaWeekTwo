
public class StringClass {

	
	
	
	
	
	public String findlastWord (String input) {
		int goesIndex = input.indexOf("goes");
		String subString = input.substring(goesIndex, input.length());
		return subString;
	}
	
	
	public char charatValue (String input) {
		// int charValue = input.charAt(1);
		char string = input.charAt(1);
		
	//	String charString = input.substring(charValue, charValue + 1);
		return string;
	}
	
	
	
	public String replacetest (String input) {
		String replace = input.replace("e", "r");
		return replace;
	}
	
}
