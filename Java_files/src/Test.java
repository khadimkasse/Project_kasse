
public class Test {
	public static void main(String[] args) {
		String text="The quick brown fox jumped over the lazy brown dog’s back";
		TextAnalyzer textToAnalyze= new TextAnalyzer(text);
		String[] table = textToAnalyze.cut();
		
		String[] countedTable= textToAnalyze.count();
		for( int i=0; i<countedTable.length; i++) {
			System.out.println(countedTable[i]);
		}
	}
}
