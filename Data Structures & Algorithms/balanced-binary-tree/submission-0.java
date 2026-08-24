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
    
    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        getHeights(root);
        return isBalanced;
    }

    private int getHeights(TreeNode root){

        if(root == null || !isBalanced)
            return 0;

        int leftH = getHeights(root.left);
        int rightH = getHeights(root.right);
        int diff = Math.abs(leftH - rightH);
        if(diff > 1)
            isBalanced = false;
        return 1 + Math.max(leftH, rightH);
    }   
}
