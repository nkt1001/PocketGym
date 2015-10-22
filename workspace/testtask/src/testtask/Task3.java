package testtask;

import java.util.Arrays;
import java.util.Random;

public class Task3 {
	//basic array
	static String[] array = {
		"One", "Two", "Three", "Four"
	};
	
	boolean compare(String a, String b){
		//function will find a 'smaller' word between 'a' and 'b'
		return a.compareTo(b) <= 0 ? true : false;
	}
	
	String sortAndFindTheLongest(String[] strings){
		String longest = new String();
		//variable for the longest word on array
		
		for(int i = 0; i < strings.length; i++){
			//standard sorting algorithm which also 
			//find the longest string in array
			String s = strings[i];
			int minPos = i;
			for(int j = i; j < strings.length; j++){
				if(compare(strings[j], s)){
					s = strings[j];
					minPos = j;
				}
			}
			if(!s.equals(strings[i])){
			strings[minPos] = strings[i];
			strings[i] = s;
			}
			if(longest.length() < strings[i].length()) longest = strings[i];
		}
		
		return longest;
	}
	String[] createStringArray(String[] defaultArray, int size){
		//function gets default array and size of required array
		//and makes new strings by dint of defaultArray strings concationation  
		Random r = new Random();
		String[] newArray = new String[size];
		
		for(int i = 0; i < size; i++){
			String s = new String();
			//number of new future string
			int bound = r.nextInt(defaultArray.length);
			//each iteration add new string in variable s			
			for(int j = 0; j <= bound; j++){
				s = s.concat(defaultArray[r.nextInt(defaultArray.length)]);
			}
			newArray[i] = s.toLowerCase();
		}
		return newArray;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Task3 t = new Task3();
		String[] arr = t.createStringArray(array, 5);
		String s = t.sortAndFindTheLongest(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(s);
	}

}
