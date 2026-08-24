/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {  

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null)
            return true;
        
        if(root == null)
            return false;
        
        return isSame(root, subRoot) 
            || isSubtree(root.left, subRoot)
            || isSubtree(root.right, subRoot);
    }

    private boolean isSame(TreeNode n1, TreeNode n2){
        if(n1 == null && n2 == null)
            return true;
        
        if(n1 == null || n2 == null)
            return false;

        return (n1.val == n2.val) 
                && isSame(n1.left, n2.left)
                && isSame(n1.right, n2.right);
    }
}
