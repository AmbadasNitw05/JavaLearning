package my.learning.dsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryPreorderTraversal {

	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversalIter(root, list);
        return list;
    }
    
    private void preorderTraversalRec(TreeNode root, List<Integer> list){
        if(root == null) return;
        
        list.add(root.val);
        preorderTraversalRec(root.left, list);
        preorderTraversalRec(root.right, list);
    }
    
    private void preorderTraversalIter(TreeNode root, List<Integer> list){
        if(root == null) return;
        
        
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        nodeStack.push(root);
        
        while(nodeStack.size() > 0){
            
           TreeNode topNode = nodeStack.pop();
            list.add(topNode.val);
            
            if(topNode.right != null){
                nodeStack.push(topNode.right);
            }
            
            if(topNode.left != null){
                nodeStack.push(topNode.left);
            }
            
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
		
		BinaryPreorderTraversal treeTrav = new BinaryPreorderTraversal();
		System.out.println(treeTrav.preorderTraversal(root));

	}

}
