import java.util.HashSet;
import java.util.Random;

public class BloomFilter {

	int size = 0;
	int k = 0;
	int m = 0;

	public BloomFilter(int size, double factor) {

		this.size = (int) Math.round(factor * size);
		this.m = size;
		double k = Math.log(2) * this.m / this.size;
		this.k = (int) Math.round(k);

		//...
	}
	
	public void add(int key) {
		//...
	}
	
	public Boolean contains(int key) {
		
		//...
		return true;
	}
	
	public static void main(String[] args) {
		
		int n = 10_000; 
		int range = 100_000_000;
		double factor = 10;

		Random random = new Random(0);
		
		BloomFilter bf = new BloomFilter(n, factor);
		
		HashSet<Integer> set = new HashSet<Integer>(n);
		
		while(set.size() < n) {
			set.add(random.nextInt(range));
		}
		
		for(int item : set) {
			bf.add(item);
		}
		
		int TP = 0, FP = 0, TN = 0, FN = 0;
		
		for(int i = 0; i < range; i++) {
			int key = i; //random.nextInt(range);
			Boolean containsBF = bf.contains(key);
			Boolean containsHS = set.contains(key);
			
			if(containsBF && containsHS) {
				TP++;
			} else if(!containsBF && !containsHS) {
				TN++;
			} else if(!containsBF && containsHS) {
				FN++;
			}  else if(containsBF && !containsHS) {
				FP++;
			}   
		}
		
		System.out.println("TP = " + String.format("%6d", TP) + "\tTPR = " + String.format("%1.4f", (double) TP/ (double) n));
		System.out.println("TN = " + String.format("%6d", TN) + "\tTNR = " + String.format("%1.4f", (double) TN/ (double) (range-n)));
		System.out.println("FN = " + String.format("%6d", FN) + "\tFNR = " + String.format("%1.4f", (double) FN/ (double) (n)));
		System.out.println("FP = " + String.format("%6d", FP) + "\tFPR = " + String.format("%1.4f", (double) FP/ (double) (range-n)));
		
	}

}
