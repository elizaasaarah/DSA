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
class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        
        int length = getLength(head);
        int rotate = k % length;
        
        if(length == rotate) return head;
        
        ListNode rotateHead = head;
        while(rotate-- > 0) {
            rotateHead = rotateList(rotateHead);
        }
        
        return rotateHead;
    }
    
    private ListNode rotateList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        
        prev.next = null;
        curr.next = head;
        
        return curr;
    }
    
    private int getLength(ListNode head) {
        int length = 0;
        
        while(head != null) {
            length++;
            head = head.next;
        }
        
        return length;
    }
}
