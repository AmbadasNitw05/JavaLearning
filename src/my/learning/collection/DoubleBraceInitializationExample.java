package my.learning.collection;

import java.util.ArrayList;
import java.util.List;

public class DoubleBraceInitializationExample {

	public static void main(String[] args) {
		List<Integer> values = new ArrayList<Integer>() { // Outer brace - Anonymous inner class
			{ // Initialization of anonymous inner class
				add(43);
				add(33);
				add(40);
			}
		};
		
		values.forEach(System.out::println); // Stream API
	}
}
