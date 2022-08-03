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
    // private List<Integer>res = new LinkedList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        // preOrder(root);
        // return res;
        List<Integer>list = new ArrayList<>();
        if(root == null)
            return list;
        Stack<TreeNode>stk = new Stack<>();
        stk.push(root);
        while(true){
            int count = stk.size();
            if(count == 0)
                break;
            while(count > 0){
                TreeNode temp = stk.pop();
                list.add(temp.val);
                if(temp.right != null)
                    stk.push(temp.right);
                if(temp.left != null)
                    stk.push(temp.left);
                count--;
            }
        }
        return list;
    }
    // public void preOrder(TreeNode root){
    //     if(root == null)
    //         return;
    //     res.add(root.val);
    //     preOrder(root.left);
    //     preOrder(root.right);
    // }
}