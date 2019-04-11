import java.util.Scanner;

public class Isbngenerator {
	public static void main(String[]args) {
		System.out.println("Enter any Product ID to get the ISBN Number:");
		Scanner inputIsbn = new Scanner(System.in);
		String productId = inputIsbn.nextLine();
		if(productId.length() == 12 && productId.matches("[0-9]+")) {
			String partialIsbn = productId.substring(3); //extracting the 9 digit partial ISBN number.
			String finalIsbnNumber = processIsbn(partialIsbn);
			System.out.println(finalIsbnNumber);
		}
		else {
			System.out.println("Please enter a valid Product Id!!!");
		}
	}

/* This method returns a valid ISBN number for the partial ISBN number entered
	 * @param partialIsbn derived from the user input  
	 * @return final correct ISBN number for the given partialIsbn number
	 */
	
	public static String processIsbn(String partialIsbn) {
		
		String [] partialIsbnArray = partialIsbn.split("");
		int[] isbnNumber = new int[partialIsbn.length()];
		int weightedSum = 0, multiple = 10;
		String finalDigit = "";
		
		for(int i=0; i<partialIsbn.length(); i++) {
			isbnNumber[i] =Integer.parseInt(partialIsbnArray[i]) ;
		//Weighted sum of digits
			weightedSum = weightedSum + isbnNumber[i]*multiple;
			multiple--;
		}
		int weightedSumMod = weightedSum % 11;
		
		if (weightedSumMod ==0) 
			//no reminder so the final digit should be zero
			finalDigit ="0";
		
		else if (weightedSumMod ==1) 
			 //since the final digit is 10, assigning final digit as 'x'
			finalDigit ="x";
		else
			finalDigit =Integer.toString(11 - weightedSum%11);
	
		String finalIsbn = partialIsbn + finalDigit;
		return finalIsbn;
		
	}

}
