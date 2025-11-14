// Node class represents a single element of the linked list
class Node {
    int data;   // stores value
    Node next;  // stores reference to the next node

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

// Class that contains operations for deleting head & tail, inserting, and printing
class DeleteTail {
    Node head;   // reference to the first node of the linked list

    // -------------------------------
    // Delete the head (first node)
    // -------------------------------
    public Node HeadRemoval() {

        // If the list is empty, nothing to delete
        if (head == null)
            return head;

        // Move head to the next node, removing the first node
        head = head.next;
        return head;
    }

    // -------------------------------
    // Delete the tail (last node)
    // -------------------------------
    public Node RemovalTail() {

        // If list is empty, no deletion possible
        if (head == null)
            return head;

        // If list has only ONE node (head.next == null)
        // then removing tail means list becomes empty
        if (head.next == null) {
            head = null;
            return head;
        }

        // temp will stop at the second-last node
        Node temp = head;

        // Move until temp.next.next becomes null
        // Meaning: temp.next is the last node
        while (temp.next.next != null) {
            temp = temp.next;
        }

        // Remove last node by setting second-last's next to null
        temp.next = null;

        return head;
    }

    // --------------------------------------
    // Insert node at the end of the list
    // --------------------------------------
    public void InsertNodeAtEnd(int data) {
        Node newNode = new Node(data, null);

        // If list is empty, new node becomes head
        if (head == null) {
            head = newNode;
            return;
        }

        // Otherwise, traverse to last node
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        // Link last node to new node
        temp.next = newNode;
    }

    // --------------------------------------
    // Print all nodes of the linked list
    // --------------------------------------
    public void printNode() {
        Node temp = head;

        // Traverse and print each node
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}

public class DeletingTail {
    public static void main(String[] args) {

        // Create linked list object
        DeleteTail ln = new DeleteTail();

        // Insert elements at end
        ln.InsertNodeAtEnd(10);
        ln.InsertNodeAtEnd(20);
        ln.InsertNodeAtEnd(30);
        ln.InsertNodeAtEnd(40);

        // Delete tail (40)
        ln.RemovalTail();

        // Print list after deletion
        ln.printNode();

        // Delete tail again (30)
        ln.RemovalTail();
    }
}
