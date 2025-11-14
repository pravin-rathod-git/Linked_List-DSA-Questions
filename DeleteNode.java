// Node class represents a single element of the linked list
class Node {
    int data;       // stores value
    Node next;      // reference to the next node

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

// Class containing all linked list operations
class DeleteTail {
    Node head;   // reference to the first node of the list

    // -------------------------------
    // Delete the head (first node)
    // -------------------------------
    public Node HeadRemoval() {
        if (head == null)     // list empty
            return head;

        head = head.next;     // move head forward
        return head;
    }

    // -------------------------------
    // Delete the tail (last node)
    // -------------------------------
    public Node RemovalTail() {

        if (head == null)     // empty list
            return head;

        if (head.next == null) {  // only one node
            head = null;
            return head;
        }

        Node temp = head;

        // Stop at second-last node
        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;     // remove last node
        return head;
    }

    // --------------------------------------
    // Insert node at the end of the list
    // --------------------------------------
    public void InsertNodeAtEnd(int data) {
        Node newNode = new Node(data, null);

        if (head == null) {     // list empty
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;     // attach new node
    }

    // --------------------------------------
    // Print all nodes of the linked list
    // --------------------------------------
    public void printNode() {
        Node temp = head;

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    // --------------------------------------
    // Delete K-th node of the list
    // --------------------------------------
    public Node DeleteKthNode(int k) {

        if (head == null || k <= 0)   // invalid
            return head;

        // Case 1: delete first node
        if (k == 1) {
            head = head.next;
            return head;
        }

        Node temp = head;
        int count = 1;

        // Move to (k-1)-th node
        while (temp != null && count < k - 1) {
            temp = temp.next;
            count++;
        }

        // If k > length of list
        if (temp == null || temp.next == null)
            return head;

        // Node to delete
        Node toDelete = temp.next;

        // Skip the k-th node
        temp.next = temp.next.next;

        toDelete.next = null;  // optional cleanup

        return head;
    }
}


// ======================================================
// MAIN CLASS TO TEST ALL OPERATIONS
// ======================================================
public class DeleteNode {
    public static void main(String[] args) {

        DeleteTail list = new DeleteTail();

        // Insert elements
        list.InsertNodeAtEnd(10);
        list.InsertNodeAtEnd(20);
        list.InsertNodeAtEnd(30);
        list.InsertNodeAtEnd(40);
        list.InsertNodeAtEnd(50);

        System.out.println("Original List:");
        list.printNode();


        // Delete 2nd node
        System.out.println("\nAfter deleting 2nd node:");
        list.DeleteKthNode(2);
        list.printNode();
    }
}
