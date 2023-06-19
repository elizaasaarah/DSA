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
class SolutionA {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        
        ListNode prev = null, curr = head;
        
        while(curr != null) {
            if(curr.val == val) {
                // this is the head element
                if(prev == null) {
                    head = head.next;
                    curr = head;
                }
                else {
                    prev.next = curr.next;
                    curr = curr.next;
                }
            }
            else {
                prev = curr;
                curr = curr.next;
            }
        }
        
        return head;
    }
}
