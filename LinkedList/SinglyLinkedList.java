public class SinglyLinkedList {
    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    Node head;
    SinglyLinkedList() {
        this.head = null;
    }

    private Node createNode(int value) {
        return new Node(value);
    }

    private Node createNodeWithNext(int value, Node next) {
        return new Node(value, next);
    }

    private Node getLastNode() {
        Node ptr = head;

        while(ptr.next != null) {
            ptr = ptr.next;
        }

        return ptr;
    }

    private int getLength() {
        Node ptr = head;
        int length = 0;

        while(ptr != null) {
            ptr = ptr.next;
            length++;
        }

        return length;
    }

    public void addAtHead(int value) {
        if (head == null) {
            head = createNode(value);
            return;
        }

        head = createNodeWithNext(value, head);
    }

    public void addAtTail(int value) {
        if(head == null) {
            addAtHead(value);
            return;
        }

        Node lastNode = getLastNode();
        lastNode.next = createNode(value);
    }

    // add val before the specified index
    public void addAtIndex(int index, int value) {
        int length = getLength();

        // index is invalid
        if(index < 0 || index > length) {
            return;
        }

        // add at head
        if(index == 0 || head == null) {
            addAtHead(value);
            return;
        }

        // add at tail
        if(index == length) {
            addAtTail(value);
            return;
        }

        Node ptr = head;
        int currIndex = 0;

        while(currIndex != (index - 1)) {
            ptr = ptr.next;
            currIndex++;
        }

        ptr.next = createNodeWithNext(value, ptr.next);
    }

    public Node search(int value) {
        Node ptr = head;

        while(ptr != null && ptr.value != value) {
            ptr = ptr.next;
        }

        return ptr;
    }

    public void deleteAtHead() {
        if(head == null) return;

        head = head.next;
    }

    public void deleteAtTail() {
        if(head == null) return;

        Node prev = null, curr = head;
        while(curr.next != null) {
            prev = curr;
            curr = curr.next;
        }

        // if there's only one node
        if(prev == null) {
            head = null;
            return;
        }

        prev.next = null;
    }

    public void deleteAtIndex(int index) {
        if(head == null) return;

        int length = getLength();
        if(index < 0 || index >= length) {
            return;
        }

        if(index == 0) {
            deleteAtHead();
            return;
        }
        if(index == length - 1) {
            deleteAtTail();
            return;
        }

        Node ptr = head;
        int currIndex = 0;
        while(ptr != null && currIndex != (index-1)) {
            ptr = ptr.next;
            currIndex++;
        }

        ptr.next = ptr.next.next;
    }

    public int get(int index) {
        int length = getLength();

        if(index < 0 || index >= length) return -1;

        Node ptr = head;
        int curr = 0;

        while(ptr != null && curr != index) {
            curr++;
            ptr = ptr.next;
        }

        return ptr.value;
    }

    public void print() {
        Node ptr = head;

        while(ptr != null) {
            System.out.print(ptr.value + " => ");
            ptr = ptr.next;
        }

        System.out.println("NULL");
    }
    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();

        /*
            ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
            [[], [1], [3], [1, 2], [1], [1], [1]]
         */
        // 1 -> 2 -> 3
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);
        System.out.println(linkedList.get(1)); // 2
        linkedList.deleteAtIndex(1); // 2
        System.out.println(linkedList.get(1)); // 3
        linkedList.print();

        /*
            ["MyLinkedList","addAtIndex","get"]
            [[],[1,0],[0]]
       */

        SinglyLinkedList ll2 = new SinglyLinkedList();
        ll2.addAtIndex(1, 0);
        System.out.println(ll2.get(0));
        ll2.print();;
    }
}
