
public class Test {
	public static void main(String[] args) {
		String text="The quick brown fox jumped over the lazy brown dog’s back";
		TextAnalyzer textToAnalyze= new TextAnalyzer(text);
		String[] table = textToAnalyze.cut();
		for( int i=0; i<table.length; i++) {
			System.out.println(table[i]);
		}
	}
}
