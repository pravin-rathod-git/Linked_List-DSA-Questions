// Node class
class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class DeleteKey {
    Node head;

    // Insert node at end for testing
    public void insert(int data) {
        Node newNode = new Node(data, null);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Function to delete all occurrences of a key
    public Node DeleteKeyLL(int key) {
        if (head == null) return null;

        // Handle deletion of head nodes matching key
        while (head != null && head.data == key) {
            head = head.next;
        }

        Node temp = head;
        Node prev = null;

        while (temp != null) {
            if (temp.data == key) {
                prev.next = temp.next;
                temp = temp.next;
            } else {
                prev = temp;
                temp = temp.next;
            }
        }

        return head;
    }

    // Print linked list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class DeleteAllOcuurencesOfkey {
    public static void main(String[] args) {
        DeleteKey list = new DeleteKey();

        // Create list: 1 -> 2 -> 3 -> 2 -> 4 -> 2
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(2);
        list.insert(4);
        list.insert(2);

        System.out.println("Original Linked List:");
        list.printList();

        int key = 2;
        list.DeleteKeyLL(key);

        System.out.println("After deleting all occurrences of " + key + ":");
        list.printList();
    }
}
