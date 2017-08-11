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


	public String[] cut() {
	//This method converts the text to analyze into a table using the blank spaces as separators 
		String[] tab= text.split(" ") ;
		return tab;
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
		
	}

}
