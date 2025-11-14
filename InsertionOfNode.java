// Node class
class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

// Custom LinkedList class for insertion operations
class MyLinkedList {
    Node head;

    // Insert at K-th position
    public Node insertAtKthPosition(int data, int k) {

        // If list is empty
        if (head == null) {
            Node newNode = new Node(data, null);
            head = newNode;
            return head;
        }

        // Insert at head
        if (k == 1) {
            Node newNode = new Node(data, head);
            head = newNode;
            return head;
        }

        Node temp = head;
        int count = 1;

        // Move temp to (k-1)th node
        while (temp != null && count < k - 1) {
            temp = temp.next;
            count++;
        }

        // If out of range
        if (temp == null) {
            System.out.println("Position out of range!");
            return head;
        }

        Node newNode = new Node(data, temp.next);
        temp.next = newNode;

        return head;
    }

    // Print linked list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

// Main class (must match file name)
public class InsertionOfNode {
    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();

        list.insertAtKthPosition(10, 1);
        list.insertAtKthPosition(20, 2);
        list.insertAtKthPosition(30, 3);
        list.insertAtKthPosition(15, 2);

        System.out.println("Final Linked List:");
        list.printList();
    }
}
