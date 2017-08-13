import java.util.Arrays;

/**
 * @author Cheikh KASSE
 *
 */
public class TextAnalyzer {

	private String text;
	
	/**
	 * @param text
	 * Constructor: Construct an object containing the text to analyze
	 */
	public TextAnalyzer(String text) {
		this.text=text;
	}
		
	/**
	 * @return
	 * Getter
	 */
	public String getText() {
		return text;
	}


	/**
	 * @param text
	 * Setter
	 */
	public void setText(String text) {
		this.text = text;
	}


	/**
	 * @return
	 * This method converts the text to analyze into a 
	 * table using the blank spaces as separators 
	 */
	private String[] cut() {
		String[] tab= this.getText().split(" ") ;
		return tab;
	}
	
	/**
	 * @param table
	 * @param start
	 * @param end
	 * @return
	 * Extract a sub-table from a table between two given indices 
	 */
	private static String[] subTable(String[] table,int start, int end){
		String[] subTable = new String[end-start+1];
		for(int index=start; index<=end; index++) {
			subTable[index-start]=table[index];
		}
		return subTable;
	}
	
	/**
	 * @param table
	 * @param i
	 * @param j
	 * Puts an index of a table in another place and pushes all the elements left	 */
	private static void replace(String[] table,int i, int j) {
		String temp = table[i];
		table[i]=table[j];
		String[] subtable = subTable(table,i+1,j-1);
		table[i+1]=temp;
		for(int k =i+2;k<=j; k++) {
			table[k] = subtable[k-i-2];
		}
	}
	

	
	
	/**
	 * @param table
	 * @return
	 * Returns the index of the smallest String of a table of String 
	 */
	private static int smaller(String[] table) {
		int index=0;
		for(int i=1;i<table.length;i++) {
			if(table[i].length() < table[index].length()) {
				index=i;			
			}
		}
		return index;
	}
	
	/**
	 * @param table
	 * This method sorts the worlds of a given table of String by length
	 */
	private static void sortByLength(String[] table) {
		int nb=table.length; 
		int smaller;
		for(int i=0;i<nb-1;i++) {
			smaller =smaller(subTable(table,i,nb-1));
			if(smaller>0) replace(table,i,i+smaller);// to avoid replacing anything when the word is well placed 
		}
	}
	
	/**
	 * @param tab
	 * @return a table of String 
	 * This method sorts a given table of String objects. The method uses the sort method given by JAVA API
	 */
	public static void sortByASCII(String[] tab) {
		Arrays.sort(tab);
	}
	
	/**
	 * @param table
	 * @return
	 * This method use the two method of sorting to provide the last sorted table needed.
	 */
	public static void sort(String[] table) {
		sortByASCII(table);
		sortByLength(table);
		
	}
	/**
	 * @return
	 * This method counts how many different words we have on the text
	 */
	private int numberOfDistinctElements() {
		int total=0;
		String[] sortedTab=this.cut();
		sort(sortedTab);
		int nb=sortedTab.length;
		for(int index=0; index<nb-1; index++) {
			if(!(sortedTab[index].equals(sortedTab[index+1]))) total++;
		}
		//For the last element of the table:
		if(!(sortedTab[nb-1].equals(sortedTab[nb-2]))) total++;
		return total;
	}
	
	/**
	 * @return
	 * Return the sorted table and the occurrence of each word
	 */
	private String[] count(){
		String[] sortedTab =this.cut();
		sort(sortedTab);
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
	
	/**
	 * @param textToAnalyze
	 * Prints the result of analyze of the given text 
	 */
	public void analyze() {
		String [] countingResult = this.count();
		for( int i=0; i<countingResult.length; i++) {
			System.out.println(countingResult[i]);
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String text="The quick brown fox jumped over the lazy brown dog’s back";
		TextAnalyzer textToAnalyze= new TextAnalyzer(text);
		
		String [] table=textToAnalyze.cut();
		String[] countedTable= textToAnalyze.count();
		
		/*//test replace
		replace(table,1,4);
		for( int i=0; i<table.length; i++) {
			System.out.println(table[i]);
		}*/
		
		
		/*//Test:smaller();
		for(int i=0;i<table.length-1;i++) {
			int smaller =smaller(subTable(table,i,table.length-1));
			System.out.println("Plus peut indice: " + smaller + " " +subTable(table,i,table.length-1)[smaller]);
			if(i!=smaller) replace(table,i,i+smaller);
			System.out.println("Tableau analysé au tour :" + i);
			for( int j=0; j<subTable(table,i,table.length-1).length; j++) {
				System.out.println(table[j]);
			}
			
		}
		*/
		
		/*
		//Test:subtable;
		String[] subtable=subTable(table,2,10);
		*/
		
		//Test: sortByLength()
		sort(table);
		for( int i=0; i<table.length; i++) {
			System.out.println(table[i]);
		}
	}
}
