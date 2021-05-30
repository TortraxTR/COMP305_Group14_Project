import java.util.Scanner; 
import java.util.HashMap; 

public class MainAlgorithm {
	public static int given_value_count; 
	public static int asked_value_count; 
	public static HashMap<Integer, Integer> original_pixels = new HashMap<Integer, Integer>(); 
	public static HashMap<Double, Integer> new_pixels = new HashMap<Double, Integer>(); 
	public static void main(String[] args) { // todo auto-generated method stub 
		Scanner read = new Scanner(System.in); 
		given_value_count = read.nextInt(); 
		asked_value_count = read.nextInt(); 
		
		for(int i = 0; i< given_value_count; i++) { 
			int value = read.nextInt(); 
			int count = read.nextInt(); 
			original_pixels.put(value,count); 
		} 
		
		read.close(); 
		System.out.print(original_pixels.get(6)); } 
	
	}