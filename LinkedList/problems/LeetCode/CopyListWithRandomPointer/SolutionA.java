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

class SolutionA {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        
        Map<Node, Node> mapping = new HashMap();
        Node ptr = head;
        
        while(ptr != null) {            
            Node newHead = mapping.getOrDefault(ptr, new Node(ptr.val));
            
            if(!mapping.containsKey(ptr)) {
                mapping.put(ptr, newHead);
            }
            
            ptr = ptr.next;
        }
        
        Node curr = mapping.get(head);
        ptr = head;
        
        while(curr != null) {
            Node random = ptr.random;
            Node next = ptr.next;
            
            curr.random = (random == null) ? null : mapping.get(random);
            curr.next = (next == null) ? null : mapping.get(next);
            
            curr = curr.next;
            ptr = ptr.next;
        }
        
        return mapping.get(head);
    }
}
