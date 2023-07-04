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
class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return head;
        
        ListNode ptr = head, prev = null;
        while(ptr != null && ptr.next != null) {
            ListNode next = ptr.next;
            ListNode after = next.next;
            
            next.next = ptr;
            ptr.next = after;
            
            if(prev == null) {
                head = next;
            }
            else {
                prev.next = next;
            }
            prev = ptr;
            
            ptr = after;
        }
        
        return head;
    }
}
