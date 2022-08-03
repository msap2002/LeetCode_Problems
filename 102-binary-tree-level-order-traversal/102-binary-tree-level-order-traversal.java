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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>list = new ArrayList<>();
        if(root == null)
            return list;
        Queue<TreeNode>q = new LinkedList<>();
        q.add(root);
        while(true){
            int count = q.size();
            List<Integer>list1 = new ArrayList<>();
            if(count == 0)
                break;
            while(count > 0){
                TreeNode temp = q.peek();
                list1.add(temp.val);
                q.remove();
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
                count--;
            }
            list.add(list1);
        }
        return list;
    }
}