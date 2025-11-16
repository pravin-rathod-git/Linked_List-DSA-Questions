class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class SortLL {
    Node head;

    // Insert at end
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

    // Print linked list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Sort LL containing 0, 1, 2
    public Node SortingLL() {
        if (head == null || head.next == null) return head;

        Node zerosHead = new Node(-1, null);
        Node onesHead = new Node(-1, null);
        Node twosHead = new Node(-1, null);

        Node zero = zerosHead, one = onesHead, two = twosHead;

        Node temp = head;

        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;
                zero = temp;
            } else if (temp.data == 1) {
                one.next = temp;
                one = temp;
            } else {
                two.next = temp;
                two = temp;
            }
            temp = temp.next;
        }

        // Connect lists
        zero.next = (onesHead.next != null) ? onesHead.next : twosHead.next;
        one.next = twosHead.next;
        two.next = null; // avoid cycle

        head = zerosHead.next; // update head
        return head;
    }
}

public class SortLLOf012 {

    public static void main(String[] args) {

        SortLL s = new SortLL();

        // Insert values (0,1,2 only)
        s.insert(2);
        s.insert(1);
        s.insert(0);
        s.insert(2);
        s.insert(1);
        s.insert(0);

        System.out.println("Original List:");
        s.printList();

        s.SortingLL();  // sort the list

        System.out.println("Sorted List:");
        s.printList();
    }
}
