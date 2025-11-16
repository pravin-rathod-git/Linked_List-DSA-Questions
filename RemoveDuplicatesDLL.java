class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
    }
}

class DoublyLinkedList {
    Node head;

    // Insert at end
    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) temp = temp.next;

        temp.next = newNode;
        newNode.prev = temp;
    }

    // Remove duplicates from sorted DLL
    public void removeDuplicates() {
        if (head == null) return;

        Node curr = head;

        while (curr != null && curr.next != null) {
            if (curr.data == curr.next.data) {
                Node duplicate = curr.next;
                curr.next = duplicate.next;

                if (duplicate.next != null) {
                    duplicate.next.prev = curr;
                }
            } else {
                curr = curr.next;
            }
        }
    }

    // Print DLL forward
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class RemoveDuplicatesDLL {
    public static void main(String[] args) {

        DoublyLinkedList dll = new DoublyLinkedList();

        // Sorted DLL: 1 <-> 2 <-> 2 <-> 3 <-> 3 <-> 4
        dll.insert(1);
        dll.insert(2);
        dll.insert(2);
        dll.insert(3);
        dll.insert(3);
        dll.insert(4);

        System.out.println("Original DLL:");
        dll.printList();

        dll.removeDuplicates();

        System.out.println("After Removing Duplicates:");
        dll.printList();
    }
}
