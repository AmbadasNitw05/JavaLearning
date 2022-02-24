package my.learning.optimal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinPacking {
	
	// First-Fit Decreasing algorithm
	
	private List<Integer> items;
	private int binCapacity;
	private List<Bin> bins;
	private static int binCounter = 0;
	
	public BinPacking(List<Integer> items, int binCapacity) {
		this.items = items;
		this.binCapacity = binCapacity;
		this.bins = new ArrayList<Bin>(items.size());
	}
	
	public void solve() {
		// Sorting the items in decreasing order
		Collections.sort(items, Collections.reverseOrder());
		
		if(this.items.get(0) > this.binCapacity) {
			System.out.println("Solution is not possible...");
			return;
		}
		
		// First-Fit algorithm
		this.bins.add(new Bin(++binCounter, this.binCapacity));
		
		for(int currentItem: items) {
			int currentBin = 0;
			boolean isOk = false;
			while(!isOk) {
				if(currentBin == this.bins.size()) {
					Bin newBin = new Bin(++binCounter, this.binCapacity);
					newBin.put(currentItem);
					this.bins.add(newBin);
					isOk = true;
				}else if(this.bins.get(currentBin).put(currentItem)) {
					isOk = true;
				}else {
					currentBin++;
				}
			}
		}
	}
	
	public void showResults() {
		for(int i=0; i<binCounter; i++) {
			System.out.println(this.bins.get(i));
		}
	}

	public static void main(String[] args) {
		List<Integer> items = Arrays.asList(10, 5, 5);
		int binCapacity = 10;
		BinPacking bp = new BinPacking(items, binCapacity);
		bp.solve();
		bp.showResults();

	}

}
