package my.learning.dsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryInorderTrav {
	
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();        
        inorderTraversalRec(root, list);
        return list;
    }
    
    public void inorderTraversalRec(TreeNode root, List<Integer> list){
        if(root == null) return;
        
        inorderTraversalRec(root.left, list);
        list.add(root.val);
        inorderTraversalRec(root.right, list);
    }
    
     public void inorderTraversalIterative(TreeNode root, List<Integer> list){
        if(root == null) return;
        
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(cur != null || stack.size() > 0) {
        	
        	// go left and push the nodes to stack
        	while(cur != null) {
        		stack.push(cur);
        		cur = cur.left;
        	}
        	
        	// print or add value
        	cur = stack.pop();
        	list.add(cur.val);
        	
        	cur = cur.right;
        	
        }
    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		
		BinaryInorderTrav treeTrav = new BinaryInorderTrav();
		System.out.println(treeTrav.inorderTraversal(root));

	}

}
