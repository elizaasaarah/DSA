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
class TwoPointersSolution {
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null) return head;

        ListNode curr = head;
        // get k-1st node
        int index = 0;
        while(index != (k-1)) {
            curr = curr.next;
            index++;
        }
        
        ListNode first = curr;
        ListNode second = head;
        
        while(curr != null && curr.next!= null) {
            curr = curr.next;
            second = second.next;
        }
        
        int firstVal = first.val;
        int secondVal = second.val;
        
        first.val = secondVal;
        second.val = firstVal;
        
        return head;
    }
}
