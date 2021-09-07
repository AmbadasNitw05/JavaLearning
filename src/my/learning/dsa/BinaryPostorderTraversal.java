package my.learning.dsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryPostorderTraversal {

	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderTraversalIter1(root, list);
        return list;
    }
    
    public void postorderTraversalRec(TreeNode root, List<Integer> list){
        if(root == null) return;
        
        postorderTraversalRec(root.left, list);
        postorderTraversalRec(root.right, list);
        list.add(root.val);
    }
    
    public void postorderTraversalIter1(TreeNode root, List<Integer> list){
    	Stack<TreeNode> s = new Stack<TreeNode>();
    	s.push(root);
    	TreeNode prev = null;
    	TreeNode cur = null;
    	while(s.size() > 0) {
    		cur = s.peek();
    		
    		if(prev == null || prev.left == cur || prev.right == cur) {
    			if(cur.left != null)
        			s.push(cur.left);
    			else if(cur.right != null)
        			s.push(cur.right); //   2 - cur , 4   -- 1 - prev
    			else {
    				s.pop();
    				list.add(cur.val);
    			}
    		}else if(cur.left == prev) {
    			if(cur.right != null)
    				s.push(cur.right);
    			else {
    				s.pop();
    				list.add(cur.val);
    			}
    		}else if(cur.right == prev) {
    			s.pop();
				list.add(cur.val);
    		}
    		
    		prev = cur;
    	}
    }
    
    public void postorderTraversalIter2(TreeNode root, List<Integer> list){
        
        Stack<TreeNode> s1 = new Stack<TreeNode>(), s2 = new Stack<TreeNode>();
        s1.push(root);
        
        while(s1.size() > 0){
            
            TreeNode temp  = s1.pop();
            s2.push(temp);
            
            if(temp.left != null) {
            	s1.push(temp.left);
            }
            if(temp.right != null) {
            	s1.push(temp.right);
            } 
            
        }
        
        while(s2.size() > 0) {
        	TreeNode temp = s2.pop();
        	list.add(temp.val);
        }
        
    }
    
    // 			4
    //		2		6
    //	  1   3   5   7
    
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		
		BinaryPostorderTraversal treeTrav = new BinaryPostorderTraversal();
		System.out.println(treeTrav.postorderTraversal(root));

	}

}
