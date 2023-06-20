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
    public boolean isPalindrome(ListNode head) {
        int length = getLength(head);
        
        int mid = length / 2;
        ListNode prev = null;
        ListNode half = head;
        while(mid > 0) {
            mid--;
            prev = half;
            half = half.next;
        }
        
        // prev.next = null;
        ListNode reversedHalf = reverse(half, null);
        ListNode reversed = reversedHalf;
        
        while(reversedHalf != null && head != null) {
            if(reversedHalf.val != head.val) return false;
            reversedHalf = reversedHalf.next;
            head = head.next;
        }
        
        if(prev != null) {
            prev.next = reverse(reversed, null);
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode head, ListNode prev) {
        if(head == null) return prev;
        
        ListNode next = head.next;
        head.next = prev;
        return reverse(next, head);
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
