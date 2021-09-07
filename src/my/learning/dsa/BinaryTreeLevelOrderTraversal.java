package my.learning.dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	
	// Breadth First Search
	public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> sameLevelNodes = new LinkedList<TreeNode>();
        List<List<Integer>> output = new ArrayList<>();        
        
        sameLevelNodes.add(root);  
        TreeNode currentNode = null;
        List<Integer> valuesAtSameLevel = null;
        while(sameLevelNodes.size() > 0){
        	valuesAtSameLevel = new ArrayList<Integer>();
        	int size = sameLevelNodes.size();
            for(int i=0; i<size; i++) {
            	currentNode = sameLevelNodes.poll();
            	valuesAtSameLevel.add(currentNode.val);
            	if(currentNode.left != null) {
            		sameLevelNodes.add(currentNode.left);
            	}
            	if(currentNode.right != null) {
            		sameLevelNodes.add(currentNode.right);
            	}            	
            }
            output.add(valuesAtSameLevel);
        }
        
        return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
