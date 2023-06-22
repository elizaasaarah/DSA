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
class SolutionB {
    public void reorderList(ListNode head) {
        if(head == null) return;
        
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null ) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode half = slow.next;
        slow.next = null;
        
        ListNode reverse = reverseList(half, null);
        
        while(head != null && reverse != null) {
            ListNode nextRev = reverse.next;
            
            reverse.next = head.next;
            head.next = reverse;
            
            head = reverse.next;
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
