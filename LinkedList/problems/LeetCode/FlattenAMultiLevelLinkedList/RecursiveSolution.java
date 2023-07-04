/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class RecursiveSolution {
    public Node flatten(Node head) {
        if(head == null) return head;
        
        Node next = head.next;
        
        if(head.child != null) {
            Node flattenedChildren = flatten(head.child);
            head.child = null;
            
            Node last = flattenedChildren;
            while(last.next != null) {
                last = last.next;
            }
            
            if(next != null) {
                next.prev = last;
            }
            
            head.next = flattenedChildren;
            flattenedChildren.prev = head;
            last.next = flatten(next);
        }
        else {
            head.next = flatten(next);
        }
        return head;
    }
}
