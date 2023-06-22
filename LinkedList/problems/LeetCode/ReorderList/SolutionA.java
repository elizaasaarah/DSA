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
    public void reorderList(ListNode head) {
        if(head == null) return;
        
        ListNode slow = head, fast = head, prev =  null;
        while(fast != null) {
            if(fast.next != null)
                fast = fast.next.next;
            else fast = null;
            prev = slow;
            slow = slow.next;
        }
        
        if(prev != null) {
            prev.next = null;
        }
        
        ListNode reverse = reverseList(slow, null);
        
        while(head != null && reverse != null) {
            ListNode nextHead = head.next;
            ListNode nextRev = reverse.next;
            
            reverse.next = null;
            reverse.next = nextHead;
            head.next = reverse;
            
            head = head.next.next;
            reverse = nextRev;
        }
        
    }
    
    private ListNode reverseList(ListNode head, ListNode prev) {
        if(head == null) return prev;
        
        ListNode next = head.next;
        
        head.next = prev;
        return reverseList(next, head);
    }
}
