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
class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {        
        ListNode oddHead = new ListNode(0);
        ListNode evenHead = new ListNode(0);
        
        ListNode oddCurr = oddHead, evenCurr = evenHead;
        
        ListNode odd = head, even = (head == null) ? null : head.next;
        
        while(even != null && even.next != null) {
            oddCurr.next = odd;
            oddCurr = oddCurr.next;
            odd = even.next;
            
            evenCurr.next = even;
            evenCurr = evenCurr.next;
            even = odd.next;
        }
        
        oddCurr.next = odd;
        oddCurr = oddCurr.next;

        evenCurr.next = even;

        if(oddCurr != null)
            oddCurr.next = evenHead.next;

        return oddHead.next;
    }
}
