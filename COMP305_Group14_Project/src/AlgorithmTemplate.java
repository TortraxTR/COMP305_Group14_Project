import java.util.*;


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
		
		
		System.out.println(original_pixels);
		MainAlgorithm NewAlgo = new MainAlgorithm();	
		int val[] = {83};
		System.out.printf( "Calculated Loss: %d\n" ,(NewAlgo.CalculateLoss(original_pixels, val)));
		
		
	
		//int optimization_val = read.nextInt(); // will be discarded later, because algorithm will internally assign it.
		
		
		int[] opt_vals = NewAlgo.GenerateGreedyOpt(original_pixels, asked_value_count);
		System.out.printf( "Calculated Loss with Greedy Algorithm: %d\n" ,(NewAlgo.CalculateLoss(original_pixels, opt_vals)));
		
		
		
		read.close(); 
		} 
	
	
	/*  
 	LOSS = px_count.(px_val - assigned_opt)^2 
 	
  * * * * 	
 	* * 
 	 * 
 */




	
public int CalculateLoss(HashMap<Integer,Integer> hash, int[] k_val_array) {	 
	
int size = k_val_array.length;	
int total_loss = 0;
int val = 0;
int min = 2147483647; // largest possible integer


for(int i : hash.keySet()) {

		for(int x=0; x < size; x++) {
			val = hash.get(i) * (i - k_val_array[x]) * (i - k_val_array[x]);
			if( val < min ) {
				min = val;
			}	
		}
	System.out.printf("for hash key %d, minimum is %d\n", i, min);	
	total_loss += min; 	
	min = 2147483647;
}
return total_loss;
}


public int GenerateOptK(HashMap<Integer,Integer> hash, int allowed_k_num) {
	// main method where we find optimal approx. for hash keys, return type may change to another hashmap. 
	return 0;
}


public int[] GenerateGreedyOpt (HashMap<Integer,Integer> hash, int allowed_k_num) { // returns greedy k values for opt.
	
	List<Integer> px_counts = new ArrayList<Integer>();
	
	for(int i : hash.keySet()) {
			px_counts.add(hash.get(i));
		}
	
	Collections.sort(px_counts, Collections.reverseOrder());
	int[] k_vals = new int[allowed_k_num];
	
	for(int i=0; i<allowed_k_num; i++) {
		k_vals[i] = px_counts.get(i); 
	}
	
	
	return k_vals;


} 


}




