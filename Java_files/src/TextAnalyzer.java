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
	
	public String[] count(){
		String[] sortedTab =tableSort(this.cut());
		String[] countingResult = new String[sortedTab.length];
		int nb=sortedTab.length-1;
		int count = 1;
		for(int index=0; index<nb; index++) {
			if(sortedTab[index].equals(sortedTab[index+1])) count+=1;
			else 
			{
				countingResult[index] = (count) +" "+ sortedTab[index];
				count = 1;
			}
		}
		//For the last element of the table:
		if(!(sortedTab[nb].equals(sortedTab[nb-1]))){
			countingResult[nb]= 1 + " " + sortedTab[nb];
		}
		
		return countingResult;
	}
	public static void main(String[] args) {
		
	}

}
