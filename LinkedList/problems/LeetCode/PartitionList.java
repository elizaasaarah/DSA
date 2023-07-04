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
class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyLess = new ListNode(-1);
        ListNode dummyMore = new ListNode(-1);
        
        ListNode currLess = dummyLess, currMore = dummyMore;
        
        ListNode ptr = head;
        
        while(ptr != null) {
            ListNode next = ptr.next;
            ptr.next = null;
            if(ptr.val < x) {
                currLess.next = ptr;
                currLess = currLess.next;
            }
            else {
                currMore.next = ptr;
                currMore = currMore.next;
            }
            
            ptr = next;
        }
        
        currLess.next = dummyMore.next;
        return dummyLess.next;
    }
}
