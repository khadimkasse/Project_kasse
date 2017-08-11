import java.util.Arrays;

public class TextAnalyzer {

	String text;
	
	public TextAnalyzer(String text) {
		this.text=text;
	}
		
	public String getText() {
	//Getter
		return text;
	}


	public void setText(String text) {
	//Setter
		this.text = text;
	}


	private String[] cut() {
	//This method converts the text to analyze into a table using the blank spaces as separators 
		String[] tab= text.split(" ") ;
		return tab;
	}
	
	private static void replace(String[] table,int i, int j) {
	//Exchange values of two given indices of a table 
		String temp=table[i];
		table[i]=table[j];
		table[j]=temp;
	}
	
	private static String[] subTable(String[] table,int start, int end){
	//Extract a sub-table from a table between two given indices 
		String[] subTable = new String[end-start];
		for(int index=start; index<end; index++) {
			subTable[index]=table[index];
		}
		return subTable;
	}
	
	private static int smaller(String[] table) {
	// Returns the index of the smallest String of a table of String 
		int index=0;
		for(int i=1;i<table.length;i++) {
			if(table[i].length() < table[index].length()) {
				index=i;			
			}
		}
		return index;
	}
	
	private static void sortByLength(String[] table) {
		int nb=table.length; 
		for(int i=0;i<nb-1;i++) {
			String smaller =table[smaller(subTable(table,i,nb))];
		}
	}
	public static String[] tableSort(String[] tab) {
	// This method sorts a given table of String objects. It will be used in the class.
		Arrays.sort(tab);
		return tab;
	}
	
	private int numberOfDistinctElements() {
		// This method counts how many different words we have on the text
		int total=0;
		String[] sortedTab =tableSort(this.cut());
		int nb=sortedTab.length;
		for(int index=0; index<nb-1; index++) {
			if(!(sortedTab[index].equals(sortedTab[index+1]))) total++;
		}
		//For the last element of the table:
		if(!(sortedTab[nb-1].equals(sortedTab[nb-2]))){
			total++;
		}
		return total;
	}
	
	public String[] count(){
		//Return the sorted table and the occurrence of each word
		String[] sortedTab =tableSort(this.cut());
		String[] countingResult = new String[this.numberOfDistinctElements()];
		int nb=sortedTab.length;
		int count = 1;// The number of time a word appears 
		int place=0;// place of the word in countingResult
		for(int index=0; index<nb-1; index++) {
			if(sortedTab[index].equals(sortedTab[index+1])) count++;
			else 
			{
				countingResult[place] = (count) +" "+ sortedTab[index];
				count = 1;
				place++;
			}
		}
		//For the last element of the table:
		if(place<this.numberOfDistinctElements()){
			countingResult[this.numberOfDistinctElements()-1]= 1 + " " + sortedTab[nb-1];
		}
		return countingResult;
	}
	public static void main(String[] args) {
		String text="The quick brown fox jumped over the lazy brown dog’s back";
		TextAnalyzer textToAnalyze= new TextAnalyzer(text);

		String[] table=textToAnalyze.cut();
		for( int i=0; i<table.length; i++) {
			System.out.println(table[i]);
		}
		textToAnalyze.replace(table, 1, 5);
		for( int i=0; i<table.length; i++) {
			System.out.println(table[i]);
		}
	}
	
}
