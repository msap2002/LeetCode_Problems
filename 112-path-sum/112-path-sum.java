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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;
        List<Integer>list = new ArrayList<>();
        computeSum(root,list,0);
        for(int i = 0;i < list.size();i++){
            if(list.get(i) == targetSum)
                return true;
        }
        return false;
    }
    public static void computeSum(TreeNode root,List<Integer>list,int sum){
        if(root.left == null && root.right == null){
            list.add(sum + root.val);
        }
        if(root.left != null){
           // sum = sum + root.val;
            computeSum(root.left,list,sum + root.val);
        }
        if(root.right != null){
            //sum = sum + root.val;
            computeSum(root.right,list,sum + root.val);
        }
    }
}