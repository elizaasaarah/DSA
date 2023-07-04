// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class DoublyLinkedList {
    Node head;
    class Node {
        int val;
        Node next, prev;

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    private int getLength() {
        Node curr = head;
        int length = 0;

        while(curr != null) {
            length++;
            curr = curr.next;
        }

        return length;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val, head, null);

        if(head != null) {
            head.prev = newNode;
        }
        head = newNode;
    }

    public void addAtTail(int val) {
        if(head == null) {
            addAtHead(val);
            return;
        }

        Node curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }

        curr.next = new Node(val, null, curr);
    }

    public void addAtIndex(int index, int val) {
        int length = getLength();
        if(index < 0 || index > length) {
            return;
        }

        if(index == 0) {
            addAtHead(val);
            return;
        }

        if(index == length) {
            addAtTail(val);
            return;
        }

        int currIndex = 0;
        Node curr = head;

        while(currIndex != index) {
            curr = curr.next;
            currIndex++;
        }

        Node prev = curr.prev;
        Node newNode = new Node(val, curr, prev);
        if(prev != null)
            prev.next = newNode;
        if(curr != null)
            curr.prev = newNode;
    }

    public int get(int index) {
        int length = getLength();
        if(index < 0 || index >= length) {
            return -1;
        }

        int currIndex = 0;
        Node curr = head;

        while(currIndex != index) {
            currIndex++;
            curr = curr.next;
        }

        return curr.val;
    }

    public void deleteAtIndex(int index) {
        int length = getLength();
        if(head == null || index < 0 || index >= length) {
            return;
        }

        if(index == 0) {
            head = head.next;
            return;
        }

        int currIndex = 0;
        Node curr = head;

        while(currIndex != index) {
            currIndex++;
            curr = curr.next;
        }

        Node prev = curr.prev;
        Node next = curr.next;

        if(prev != null) {
            prev.next = next;
        }
        if(next != null) {
            next.prev = prev;
        }
    }
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addAtHead(1);
        dll.addAtTail(3);
        dll.addAtIndex(1,2);
        System.out.println(dll.get(1));
        dll.deleteAtIndex(1);
        System.out.println(dll.get(1));
    }
}
