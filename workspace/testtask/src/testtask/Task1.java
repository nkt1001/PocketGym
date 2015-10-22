package testtask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.Random;

import org.ho.yaml.YamlDecoder;
import org.ho.yaml.YamlEncoder;

public class Task1 {
	//returns array with define size
	int[] createRandomArray(int size){
		if(size % 2 == 0){
			// if size is even program will return 'exception'
			System.out.println("Illegal size exception!"
					+ " Argument 'size' must be odd");
			return null;
		}
		
		int[] array = new int[size];
		Random r = new Random();
		//middle of array
		int mid = size/2;
		for(int i = 0; i <= mid; i++){
			//random number will be put twice into the array
			int k = r.nextInt();
			array[i] = k;
			//element at array[0] will be always unique
			//because array[4] will be overwritten in last iteration
			array[mid+i] = k;
		}
		//mixing elements
		mixElements(array, r, size);
		
		return array;
	}

	void mixElements(int[] array, Random r, int size){
		for(int i = 0; i < size; i++){
			//gets positions of two random elements
			//in array and changes their places
			int position1 = r.nextInt(size);
			int position2 = r.nextInt(size);
			
			if(position1 != position2){
				int digit1 = array[position1];
				array[position1] = array[position2];
				array[position2] = digit1;
			}
		}
	}
	
	int findUnique(int[] array){
		
		for(int i = 0; i < array.length; i++){
			//takes one element
			int counter = 0;
			for(int j = 0; j < array.length; j++){
				//compare to all others elements if they equal changes counter
				if (array[i] == array[j]) counter++;
			}
			//if for one cycle it found just one element it means that
			//this element is unique else this number repeats twice or more
			if(counter == 1) return array[i];
		}
		
		return 0;
	}
	
	void encodeYaml(File file) throws IOException{
		//encode a new file and yamlencoder
		OutputStream out = new FileOutputStream(file);
		YamlEncoder enc = new YamlEncoder(out);
		//writing new file with my random array
		enc.writeObject(createRandomArray(9));
		//close stream
		enc.close();
		out.close();
	}
	int findUniqueInYaml(File file) throws IOException{
		//creates input stream to read a file
		InputStream in = new FileInputStream(file);
		//creates a decoder
		YamlDecoder dec = new YamlDecoder(in);
		int[] array = (int[])dec.readObject();
		//finding unique number in array
		int num = findUnique(array);
		//close stream
		dec.close();
		in.close();
		return num;
	}
	
	public static void main(String[] args) throws IOException {
		Task1 t = new Task1();
		File file = new File("arrays.txt");
		if(!file.exists()) file.createNewFile();
		t.encodeYaml(file);
		int i = t.findUniqueInYaml(file);
		System.out.println("Unique is " + i);
	}
}
