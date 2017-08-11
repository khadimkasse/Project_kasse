public class TextAnalyzer {

	String text;
	
	public TextAnalyzer(String text) {
		this.text=text;
	}
	
	public String[] cut() {
		String[] tab= text.split(" ") ;
		return tab;
	}
	
	public String[][] count(){
		String[][] countingResult = null;
		
		return countingResult;
	}
	public static void main(String[] args) {
		
	}

}
