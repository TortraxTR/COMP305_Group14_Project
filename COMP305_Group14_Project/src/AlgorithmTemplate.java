import java.util.*;
import java.io.*;



public class MainAlgorithm {
	public static int given_value_count; 
	public static int asked_value_count; 
	int your_val;
	public static HashMap<Integer, Integer> original_pixels = new HashMap<Integer, Integer>(); 
	public static HashMap<Double, Integer> new_pixels = new HashMap<Double, Integer>(); 
	
	public static void main(String[] args) throws IOException { // todo auto-generated method stub 
		
		
		 FileReader fr =
			      new FileReader("./text.txt");
		
		 Scanner sc = new Scanner(fr);
		 
		 sc.useDelimiter("\\p{javaWhitespace}+");
		 
		 given_value_count = Integer.parseInt(sc.next()); 
		 asked_value_count = Integer.parseInt(sc.next()); 
		
		
		 
		  
		   while (sc.hasNext()) {
			 int a = Integer.parseInt(sc.next()); 
			 int b = Integer.parseInt(sc.next()); 
			 original_pixels.put(a, b);
		     
		    } 
		    sc.close();
		    
    
		
		System.out.println(original_pixels);
		MainAlgorithm NewAlgo = new MainAlgorithm();	
		/* int val[] = {83};
		System.out.printf( "Calculated Loss: %d\n" ,(NewAlgo.CalculateLoss(original_pixels, val))); */
		
		int[] opt_vals = NewAlgo.GenerateGreedyOpt(original_pixels, asked_value_count);
		
		for(int i=0; i<opt_vals.length; i++) {
			System.out.printf("opt value %d: %d\n", i, opt_vals[i]);
		}
		
		 System.out.printf( "Calculated Loss with Greedy Algorithm: %d\n" ,(NewAlgo.CalculateLoss(original_pixels, opt_vals))); 
		
		} 
	
	
	/*  
 	
 	LOSS = px_count.(px_val - assigned_opt)^2 
 	
  * * * * 	
 	* * 
 	 * 
 
 */

	
public long CalculateLoss(HashMap<Integer,Integer> hash, int[] k_val_array) {	 
	
int size = k_val_array.length;	
long total_loss = 0;
long val = 0;
long min = Long.MAX_VALUE; // largest possible integer


for(int i : hash.keySet()) {
		
		
	
		for(int x=0; x < size; x++) {
			val = ((i - k_val_array[x]) * (i - k_val_array[x])) * (long) hash.get(i) ;
			// System.out.printf("for hash key %d and opt_val = %d , current val is %d and current hash is: %d\n", i, k_val_array[x],val, hash.get(i));
			if( val < min ) {
				min = val;	
			}
			
			
		}
		
	
	total_loss = total_loss +  min; 	
	min = 2147483647;
}
return total_loss;
}


public int GenerateDFT(HashMap<Integer,Integer> hash, int allowed_k_num) {
	// DFT algorithm to choose (x - k)^2 roots accordingly to find min
	return 0;
}


public int[] GenerateGreedyOpt (HashMap<Integer,Integer> hash, int allowed_k_num) { // returns greedy k values for opt.
	
	long startTime = System.nanoTime();
	
	List<Integer> px_counts = new ArrayList<Integer>();
	
	for(int i : hash.keySet()) {
			px_counts.add(hash.get(i));
		}
	
	Collections.sort(px_counts, Collections.reverseOrder());
	int[] k_vals = new int[allowed_k_num];
	
	for(int x=0; x<allowed_k_num; x++) {
	for(int i : hash.keySet()) {
		if(px_counts.get(x) == hash.get(i)) {	
			k_vals[x] = i;
		} 
	
	}
	}
	long stopTime = System.nanoTime();
	System.out.println("Greedy Algorithm exec time in nanoseconds:");
	System.out.println(stopTime-startTime);
	System.out.println("");
	
	return k_vals;
} 



public int[] GenerateAlternateOpt(HashMap<Integer,Integer> old, HashMap<Integer, Integer> updated, int allowed_k_num) {
	
	int[] k_vals = new int[allowed_k_num];
	
	for(int i : old.keySet()) {
		updated.put(i, i*old.get(i)); //possible conflict
	}
	
	int valuesum = 0;
	for (int k : updated.values()) {
		valuesum+=k;
	}
	
	int average = valuesum / updated.keySet().size();
	
	//Find a way to search for the closest values to average.
	//Add the closest value's key to the return array.
	//Iterate over the remaining values if more k values are asked.
	

	return k_vals;
}


}
