package my.learning.dsa;

public class ValidBSTCheck {
 	public boolean isValidBST(TreeNode root) { 
 		
 		// return isBstRecurse(root, null, null);  // It's working statement
 		// The below is not working if null values are stored in the tree
 		
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
        if(root.left != null && root.left.val >= root.val){
            return false;
        }
        if(root.right != null && root.right.val <= root.val){
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }
 	
 	 public static boolean isBstRecurse(TreeNode root,TreeNode left,TreeNode right){
         if(root==null){
             return true;
         }
         if(left!=null && left.val>=root.val){
             return false;
         }
         if(right!=null && right.val<=root.val){
             return false;
         }
         return  isBstRecurse(root.left,left,root)&&
                 isBstRecurse(root.right,root,right);
     }
}
