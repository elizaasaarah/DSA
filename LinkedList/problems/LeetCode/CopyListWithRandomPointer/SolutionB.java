/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class SolutionB {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        
        Node ptr = head;
        
        while(ptr != null) {            
            Node newHead = new Node(ptr.val);
            
            Node next = ptr.next;
            newHead.next = next;
            ptr.next = newHead;
            
            ptr = newHead.next;
        }
        
        Node curr = head.next;
        ptr = head;
        
        while(ptr != null) {
            Node random = ptr.random;
            Node nextPtr = ptr.next;
            
            curr.random = (random == null) ? null : random.next;
            curr.next = (nextPtr == null) ? null : nextPtr.next;
            
            ptr = curr.next;
            if(ptr != null) curr = ptr.next;
        }
        
        
        Node dummyHead = new Node(-1);
        Node copyHead = dummyHead;
        ptr = head;
        while(ptr != null) {
            dummyHead.next = ptr.next;
            dummyHead = dummyHead.next;
            
            ptr.next = dummyHead.next;
            ptr = ptr.next;
        }
        
        return copyHead.next;
    }
}
