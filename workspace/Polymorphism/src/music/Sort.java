package music;

public class Sort {
	private static int[] data = {5,3,2,6,8,32,1,5,7,3,5,7,0,8,11};
	public static int[] sortMyArray(int[] array){
		for(int i =0; i < array.length; i++){
			int min=array[i];
			int imin = i;
			for(int j = i+1; j < array.length; j++){
				if(array[j]<min){
					min = array[j];
					imin = j;
				}
				
			}
			int buff = array[i];
			array[i] = min;
			array[imin] = buff;
		}
		return array;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] j = sortMyArray(data);
		for(int i : j)
		System.out.print(i + " ");
		
	}
}


