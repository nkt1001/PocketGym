package testtask;

public class Task2 {
	//boolean func which define if number is palindrome
	boolean isPalindrome(int num){
		int size = (int) Math.log10(num)+1;
		//variable size defines quantity of digits in (int num) 
		int[] digits = new int[size];
		//array digit will contains digits of num
		int i = 0;
		int mynum = num;
		
		while(mynum > 0){
			//residue of the division on 10 will gives the last digit
			digits[i] = mynum % 10;
			mynum = mynum / 10;
			i++;
		}
		
		for(int j = 0; j < size/2; j++){
			//checks the palindrome
			if(digits[j] != digits[(size-1)-j]) return false;
		}
		return true;
	}

	int findPalindrome(int num){
		int i = num;
		//while will not be a palindrome cycle will add 1 to number
		while(!isPalindrome(i)){
			i++;
		}
		return i;
	}
	public static void main(String[] args) {
		Task2 t = new Task2();
		System.out.println(t.findPalindrome(1992));
	}

}
