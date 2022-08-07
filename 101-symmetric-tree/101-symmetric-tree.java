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
    public boolean isSymmetric(TreeNode root) {
        root.right = invertTree(root.right);
        boolean ans = isSameTree(root.left,root.right);
        return ans;
    }
    public TreeNode invertTree(TreeNode root){
        if(root == null)
            return null;
        TreeNode leftTree = invertTree(root.left);
        TreeNode rightTree = invertTree(root.right);
        root.left = rightTree;
        root.right = leftTree;
        return root;
    }
    public boolean isSameTree(TreeNode p,TreeNode q){
        if(p == null && q == null)
            return true;
        if(p != null && q != null && p.val != q.val)
            return false;
        if(p == null && q != null)
            return false;
        if(p != null && q == null)
            return false;
        boolean res1 = isSameTree(p.left,q.left);
        boolean res2 = isSameTree(p.right,q.right);
        return (res1 & res2);
    }
}