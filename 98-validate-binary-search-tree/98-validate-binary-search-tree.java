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
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        if(root.left == null && root.right == null)
            return true;
        return isValidBSTBetter(root,Integer.MIN_VALUE,Integer.MAX_VALUE);    
    }
    public boolean isValidBSTBetter(TreeNode root,int minRange,int maxRange){
        if(root == null)
            return true;
        if(root.val < minRange || root.val > maxRange)
            return false;
        if(root.val == Integer.MIN_VALUE && root.left != null)
            return false;
        if(root.val == Integer.MAX_VALUE && root.right != null)
            return false;
        boolean isLeftChildValid = isValidBSTBetter(root.left,minRange,root.val - 1);
        boolean isRightChildValid = isValidBSTBetter(root.right,root.val + 1,maxRange);
        return isLeftChildValid && isRightChildValid;
    }
}