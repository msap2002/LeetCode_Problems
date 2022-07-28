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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;
        ListNode curr = head;
        while(curr.next != null){
            ListNode future = curr.next;
            if(future.val == curr.val){
                curr.next = future.next;
                //curr = future.next;
            }
            else{
                curr = future;
            }
        }
        return head;
    }
}