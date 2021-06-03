import java.util.Scanner; 
import java.util.HashMap; 

public class MainAlgorithm {
	public static int given_value_count; 
	public static int asked_value_count; 
	int your_val;
	public static HashMap<Integer, Integer> original_pixels = new HashMap<Integer, Integer>(); 
	public static HashMap<Double, Integer> new_pixels = new HashMap<Double, Integer>(); 
	
	public static void main(String[] args) { // todo auto-generated method stub 
		
		Scanner read = new Scanner(System.in); 
		
		System.out.print("enter distinct pixel value\n");
		given_value_count = read.nextInt();  // num of distinct pixel value
		System.out.print("enter num of optimization ints\n");
		asked_value_count = read.nextInt(); // num of k
		
		for(int i = 0; i< given_value_count; i++) { 
			System.out.print("give pixel val\n");
			int value = read.nextInt(); 
			System.out.print("give pixel count\n");
			int count = read.nextInt(); 
			original_pixels.put(value,count); 
		} 
		
		
		
		
		
		MainAlgorithm NewAlgo = new MainAlgorithm();
		System.out.println("Enter a value to be tested as a singular k");
		int optimization_val = read.nextInt(); // will be discarded later, because algorithm will internally assign it.
		System.out.printf("Loss is: %d\n",NewAlgo.CalculateLoss(original_pixels, optimization_val));
		read.close(); 
		} 
	
	



public int CalculateLoss(HashMap<Integer,Integer> hash, int val_tobe_tested) {	 // val_tobe_tested will be array
																				// for now let's get only 1 
	
		int total = 0;
	
		for(int i : original_pixels.keySet()) {
			 System.out.printf("%d number of pixel in value: %d\n", original_pixels.get(i), i);
			 int sq = (val_tobe_tested - i) * (val_tobe_tested - i); // we will get the corresponding k value here 
			 															// according to our algorithm function
			 total += (sq * original_pixels.get(i));
		}
	
		return total;
}


public int GenerateOptK(HashMap<Integer,Integer> hash, int allowed_k_num) {
	// main method where we find optimal approx. for hash keys, return type may change to another hashmap. 
	return 0;
}


}


