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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String>list = new ArrayList<>();
        String answer = "";
        computeBetter(root,list,answer);
        return list;
    }
    public static void computeBetter(TreeNode root,List<String>list,String answer){
        if(root.left == null && root.right == null){
            list.add(answer + root.val);
        }
        if(root.left != null){
            computeBetter(root.left,list,answer + root.val + "->");
        }
        if(root.right != null){
            computeBetter(root.right,list,answer + root.val + "->");
        }
    }
}