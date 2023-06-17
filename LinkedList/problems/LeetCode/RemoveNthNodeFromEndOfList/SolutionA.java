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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        
        int length = getLength(head);

        // If first node needs to be removed
        if(n == length) {
            head = head.next;
            return head;
        }
        
        int i = 0;
        ListNode ptr = head;
        while(i < (length - n - 1)) {
            ptr = ptr.next;
            i++;
        }
        ptr.next = ptr.next.next;
        
        return head;
    }
    
    private int getLength(ListNode head) {
        int length = 0;
        
        while(head != null) {
            head = head.next;
            length++;
        }
        
        return length;
    }
}
