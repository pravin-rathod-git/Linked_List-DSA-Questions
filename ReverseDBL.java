// Node class for Doubly Linked List
class Node {
    int data;
    Node next;
    Node back;

    // Constructor with next and back
    Node(int data, Node next, Node back) {
        this.data = data;
        this.next = next;
        this.back = back;
    }

    // Constructor for single node
    Node(int data) {
        this.data = data;
        this.next = null;
        this.back = null;
    }
}

// Class for operations on DLL
class ConvertToLinkedList {
    Node head; // Head pointer

    // ----------------------------------------------------------
    // Convert Array → Doubly Linked List
    // ----------------------------------------------------------
    public void ArrayToDLL(int arr[]) {
        head = new Node(arr[0]);  // First node
        Node prev = head;

        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i], null, prev);
            prev.next = newNode;
            prev = newNode;
        }
    }

    // ----------------------------------------------------------
    // Reverse the Doubly Linked List
    // ----------------------------------------------------------
    public Node ReverseList() {
        if (head == null || head.next == null) 
            return head;

        Node temp = head;
        Node prev = null;

        while (temp != null) {
            Node next = temp.next;

            // Swap pointers
            temp.next = prev;
            temp.back = next;

            prev = temp;
            temp = next;
        }

        head = prev; // Update head
        return head;
    }

    // ----------------------------------------------------------
    // Print DLL forward
    // ----------------------------------------------------------
    public void printForward() {
        Node temp = head;
        System.out.print("DLL: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

// ----------------------------------------------------------
// MAIN CLASS
// ----------------------------------------------------------
public class ReverseDBL {
    public static void main(String[] args) {

        ConvertToLinkedList dll = new ConvertToLinkedList();

        int arr[] = {10, 20, 30, 40, 50};

        dll.ArrayToDLL(arr);

        System.out.println("Original DLL:");
        dll.printForward();

        dll.ReverseList();

        System.out.println("Reversed DLL:");
        dll.printForward();
    }
}
