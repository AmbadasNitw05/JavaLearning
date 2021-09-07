package my.learning.test;

import my.learning.*;

public class NestedPackageImportExample {

	public static void main(String[] args) {
		MainPackageClass mainPkgObj = new MainPackageClass();
		mainPkgObj.print();
		
		// FinallyExample subPkgObj = new FinallyExample(); // Compilation error because 
		// nested pkg (my.learning.exception.*) won't be
		// imported with my.learning.* (main pkg)

	}

}
