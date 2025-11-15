class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListLoop {
    Node head;

    // Insert node at end
    public void insert(int data) {
        Node newNode = new Node(data);
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

    // Create a loop manually for testing
    public void createLoop(int position) {
        if (position == 0) return;

        Node loopNode = head;
        Node temp = head;

        int count = 1;
        while (count < position && loopNode != null) {
            loopNode = loopNode.next;
            count++;
        }

        // Go to last node
        while (temp.next != null) {
            temp = temp.next;
        }

        // Link last node to loopNode
        temp.next = loopNode;
    }

    // Find length of loop if present
    public int countLoopLength() {
        Node slow = head;
        Node fast = head;

        // Step 1: Detect loop using Floyd’s algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return countNodesInLoop(slow);  // Loop detected
            }
        }

        return 0; // No loop
    }

    // Step 2: Count number of nodes in the loop
    private int countNodesInLoop(Node loopNode) {
        Node temp = loopNode;
        int count = 1;

        while (temp.next != loopNode) {
            temp = temp.next;
            count++;
        }

        return count;
    }
}

public class CalculateLengthOfLoop{
    public static void main(String[] args) {

        LinkedListLoop list = new LinkedListLoop();

        // Insert nodes
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        // Create loop: last node connects to node at position 3 (node with data=3)
        list.createLoop(3);

        // Find loop length
        int loopLength = list.countLoopLength();

        if (loopLength == 0) {
            System.out.println("No loop present in the LinkedList.");
        } else {
            System.out.println("Length of loop = " + loopLength);
        }
    }
}
