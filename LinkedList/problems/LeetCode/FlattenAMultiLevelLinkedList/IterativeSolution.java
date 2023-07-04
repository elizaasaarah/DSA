/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class IterativeSolution {
    public Node flatten(Node head) {
        if(head == null) return head;
        
        Node curr = head;
        
        while(curr != null) {
            if(curr.child == null) {
                curr = curr.next;
                continue;
            }
            
            Node childCurr = curr.child;
            while(childCurr.next != null) {
                childCurr = childCurr.next;
            }
            
            childCurr.next = curr.next;
            if(curr.next != null) {
                curr.next.prev = childCurr;
            }
            
            curr.next = curr.child;
            curr.child.prev = curr;
            curr.child = null;
            curr = curr.next;
        }
        
        return head;
    }
}
