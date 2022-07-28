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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return null;
        ListNode temp = head;
        ListNode prev = null;
        int count = 0;
        ListNode head1 = null;
        while(temp != null){
            if(temp.val != val){
                count++;
                ListNode temp1 = new ListNode(temp.val);
                if(count == 1){
                    head1 = temp1;
                    prev = temp1;
                }
                else{
                    prev.next = temp1;
                    prev = temp1;
                }
            }
            temp = temp.next;
        }
        return head1;
    }
}