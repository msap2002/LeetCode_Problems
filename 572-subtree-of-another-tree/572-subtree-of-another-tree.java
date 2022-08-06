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
        if(root == null && subRoot == null)
            return true;
        if(root == null || subRoot == null)
            return false;
        boolean ans = isMatching(root,subRoot);
        boolean result = isSubtree(root.left,subRoot);
        boolean result2 = isSubtree(root.right,subRoot);
        if(ans||result||result2)
            return true;
        return false;
    }
    public boolean isMatching(TreeNode root,TreeNode subRoot){
        if(root == null && subRoot == null)
            return true;
        if(root != null && subRoot != null && root.val != subRoot.val)
            return false;
        if(root != null && subRoot == null)
            return false;
        if(root == null && subRoot != null)
            return false;
        boolean result1 = isMatching(root.left,subRoot.left);
        boolean result2 = isMatching(root.right,subRoot.right);
        return (result1 & result2);
    }
}