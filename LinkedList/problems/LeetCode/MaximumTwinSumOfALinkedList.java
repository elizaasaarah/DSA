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
class MaximumTwinSumOfALinkedList {
    public int pairSum(ListNode head) {
        if(head == null) return 0;
        
        ListNode slow = head, fast = head, prev = null;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;
        
        ListNode reversedHalf = reverseList(slow, null);
        
        int maxSum = 0;
        
        while(head != null && reversedHalf != null) {
            int sum = head.val + reversedHalf.val;
            
            maxSum = Math.max(sum, maxSum);
            head = head.next;
            reversedHalf = reversedHalf.next;
        }
        
        return maxSum;
    }
    
    private ListNode reverseList(ListNode head, ListNode prev) {
        if(head == null) return prev;
        
        ListNode next = head.next;
        head.next = prev;
        
        return reverseList(next, head);
    }
}
