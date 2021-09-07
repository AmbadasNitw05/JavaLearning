package my.learning.designpattern.visitorpattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	static Map<Integer, Tree> tree = new HashMap<Integer, Tree>();

	public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(); // size of the tree
		
		// read values
		int[] vals = new int[n];
		for(int i=0;i<n;i++) {
			vals[i] = scan.nextInt();
		}
		
		// read color of the nodes
		Color[] colors = new Color[n];
		for(int i=0;i<n;i++) {
			int c = scan.nextInt();
			if(c == 0) colors[i] = Color.RED;
			else colors[i] = Color.GREEN;
		}
		
		// read edges
		Map<Integer, List<Integer>> edges = new HashMap<Integer, List<Integer>>();
		for(int i=0; i<n-1;i++) {
			edges.put(i, new ArrayList<Integer>());
		}
		for(int i=0; i<n-1;i++) {
			int u = scan.nextInt()-1;
			int v = scan.nextInt()-1;
			edges.get(u).add(v);
			edges.get(v).add(u);
		}
		
		
		
		return null;
		
    }
	
	public static void main(String[] args) {
      	Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
      	ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
      	FancyVisitor vis3 = new FancyVisitor();

      	root.accept(vis1);
      	root.accept(vis2);
      	root.accept(vis3);

      	int res1 = vis1.getResult();
      	int res2 = vis2.getResult();
      	int res3 = vis3.getResult();

      	System.out.println(res1);
     	System.out.println(res2);
    	System.out.println(res3);
	}
}
