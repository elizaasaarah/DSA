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
    public ListNode middleNode(ListNode head) {
        if(head == null) return null;
        
        int length = getLength(head);
        int n = length / 2;
        
        while(n > 0) {
            head = head.next;
            n--;
        }
        
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
