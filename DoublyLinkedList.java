// Node class for Doubly Linked List
class Node {
    int data;
    Node next;
    Node back;

    // Constructor when next and back are given
    Node(int data, Node next, Node back) {
        this.data = data;
        this.next = next;
        this.back = back;
    }

    // Constructor for single value
    Node(int data) {
        this.data = data;
        this.next = null;
        this.back = null;
    }
}

// Class to convert array to Doubly Linked List & perform operations
class ConvertToLinkedList {
    Node head; // Head of DLL

    // ---------------------------------------------------------
    // Convert Array to Doubly Linked List
    // ---------------------------------------------------------
    public void ArrayToDLL(int arr[]) {
        int n = arr.length;

        // First node (head)
        head = new Node(arr[0]);
        Node prev = head;

        // Create the rest of the nodes
        for (int i = 1; i < n; i++) {
            Node newNode = new Node(arr[i], null, prev);
            prev.next = newNode;  // Forward link
            prev = newNode;       // Move prev pointer forward
        }
    }

    // ---------------------------------------------------------
    // Print DLL from head → tail
    // ---------------------------------------------------------
    public void printForward() {
        Node temp = head;
        System.out.print("Forward : ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // ---------------------------------------------------------
    // Print DLL from tail → head
    // ---------------------------------------------------------
    public void printBackward() {
        if (head == null) return;

        // Move to last node
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        System.out.print("Backward: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.back;
        }
        System.out.println();
    }

    // ---------------------------------------------------------
    // Insert at Head
    // ---------------------------------------------------------
    public void insertAtHead(int data) {
        Node newNode = new Node(data);

        // If list is empty
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head.back = newNode;
        head = newNode;
    }

    // ---------------------------------------------------------
    // Insert at Tail
    // ---------------------------------------------------------
    public void insertAtTail(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        // Go to last node
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.back = temp;
    }

    // ---------------------------------------------------------
    // Delete at Head
    // ---------------------------------------------------------
    public void deleteAtHead() {
        if (head == null) return;

        // If only one node
        if (head.next == null) {
            head = null;
            return;
        }

        head = head.next;
        head.back = null;
    }

    // ---------------------------------------------------------
    // Delete at Tail
    // ---------------------------------------------------------
    public void deleteAtTail() {
        if (head == null) return;

        // If only one node
        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;

        // Move to second last node
        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null; // Remove last node
    }
}

public class DoublyLinkedList {
    public static void main(String[] args) {

        ConvertToLinkedList dll = new ConvertToLinkedList();

        int arr[] = {10, 20, 30, 40, 50};

        // Convert array to DLL
        dll.ArrayToDLL(arr);

        dll.printForward();
        dll.printBackward();

        // Insert at head
        dll.insertAtHead(5);
        dll.printForward();

        // Insert at tail
        dll.insertAtTail(60);
        dll.printForward();

        // Delete at head
        dll.deleteAtHead();
        dll.printForward();

        // Delete at tail
        dll.deleteAtTail();
        dll.printForward();

        dll.printBackward();
    }
}
