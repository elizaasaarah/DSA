/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class SolutionB {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        
        ListNode ptrA = headA, ptrB = headB;
        
        if(lenA > lenB) {
            while(lenA != lenB) {
                ptrA = ptrA.next;
                lenA--;
            }
        }
        else {
            while(lenA != lenB) {
                ptrB = ptrB.next;
                lenB--;
            }
        }
        
        while(ptrA != ptrB) {
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }
        
        return ptrA;
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
