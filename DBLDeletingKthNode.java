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
    // Delete K-th Node in DLL
    // ----------------------------------------------------------
    public Node DeleteKthNode(int k) {

        if (head == null) return null;

        // Case 1: delete first node
        if (k == 1) {
            head = head.next;
            if (head != null) head.back = null;
            return head;
        }

        Node temp = head;
        int count = 1;

        // Move to the k-th node
        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }

        // Case: k > length
        if (temp == null) return head;

        Node prev = temp.back;
        Node next = temp.next;

        // Case 2: deleting last node
        if (next == null) {
            prev.next = null;
            temp.back = null;
            return head;
        }

        // Case 3: deleting middle node
        prev.next = next;
        next.back = prev;

        temp.next = null;
        temp.back = null;

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

// --------------------------------------------------------------
// MAIN CLASS
// --------------------------------------------------------------
public class DBLDeletingKthNode {
    public static void main(String[] args) {

        ConvertToLinkedList dll = new ConvertToLinkedList();
        int arr[] = {10, 20, 30, 40, 50};

        System.out.println("---- Convert Array to DLL ----");
        dll.ArrayToDLL(arr);
        dll.printForward();

        System.out.println("\n---- Delete 3rd Node ----");
        dll.DeleteKthNode(3);  // removes 30
        dll.printForward();

        System.out.println("\n---- Delete 1st Node ----");
        dll.DeleteKthNode(1);  // removes 10
        dll.printForward();

        System.out.println("\n---- Delete Last Node ----");
        dll.DeleteKthNode(3);  // removes 50
        dll.printForward();
    }
}
