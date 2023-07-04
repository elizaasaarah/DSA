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
class LengthSolution {
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null) return head;
        int length = 0;
        ListNode curr = head;
        
        // calculate length of list
        while(curr != null) {
            curr = curr.next;
            length++;
        }
        
        // get k-1st node
        curr = head;
        int index = 0;
        while(index != (k-1)) {
            curr = curr.next;
            index++;
        }
        
        ListNode first = curr;
        
        curr = head;
        index = 0;
        while(index != (length-k)) {
            curr = curr.next;
            index++;
        }
        ListNode second = curr;
        

        curr = head;
        
        int firstVal = first.val;
        int secondVal = second.val;
        
        while(curr != null) {
            if(curr == first) {
                curr.val = secondVal;
            }    
            else if(curr == second) {
                curr.val = firstVal;
            }
            
            curr = curr.next;
        }
        
        return head;
    }
}
