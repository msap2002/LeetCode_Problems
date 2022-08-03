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
    // private List<Integer>list = new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        
        // inOrderTraversal(root);
        // return list;
        Stack<TreeNode>stk = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        TreeNode temp = root;
        //stk.push(root);
        while(temp != null || stk.size() > 0){
            while(temp != null){
                stk.push(temp);
                temp = temp.left;
            }
            temp = stk.pop();
            list.add(temp.val);
            temp = temp.right;
        }
        return list;
    }
//     public void inOrderTraversal(TreeNode root){
//         if(root == null)
//             return;
       
//         inOrderTraversal(root.left);
//         list.add(root.val);
//         inOrderTraversal(root.right);
//     }
}