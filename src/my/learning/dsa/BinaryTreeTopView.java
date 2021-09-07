package my.learning.dsa;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTopView {

	int maxLevel = 0;
	
	public void leftViewTree(TreeNode root, int level, List<Integer> list) {
		
		if(root == null) return;
		
		if(maxLevel < level) {
			list.add(root.val);
			maxLevel = level;	 							
		}
		
		leftViewTree(root.left, level + 1, list);
		leftViewTree(root.right, level + 1, list);
		
		
	}
	
    // 			4
    //		2		6
    //	      3   5   7
	// 					8
	
	// ans: 2, 4, 6, 7, 8 -- no bottom
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(8);
		
		List<Integer> list = new ArrayList<Integer>();
		new BinaryTreeTopView().leftViewTree(root, 1, list);
		System.out.println(list.toString());

	}

}
