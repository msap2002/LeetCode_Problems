/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer>stk = new Stack<>();
        Queue<Integer>q = new LinkedList<>();
        ListNode temp = head;
        while(temp.next != null){
            stk.push(temp.val);
            q.add(temp.val);
            temp = temp.next;
        }
        stk.push(temp.val);
        q.add(temp.val);
        for(int i = 0;i < q.size();i++){
            if(q.poll() != stk.pop())
                return false;
        }
        return true;
    }
}