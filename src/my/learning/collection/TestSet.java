package my.learning.collection;

import java.util.HashSet;
import java.util.TreeSet;

public class TestSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet<String>();		
		hashSet.add("bob");
		hashSet.add("alok");
		hashSet.add("bob");
			
		System.out.println("Hash Set: " + hashSet); // [bob, alok] - no duplicates
		
		TreeSet<String> treeSet = new TreeSet<String>();		
		treeSet.add("bob");
		treeSet.add("alok");
		treeSet.add("bob");
			
		System.out.println("Tree Set: " + treeSet); // [alok, bob] - no duplicates and sorted

	}

}
