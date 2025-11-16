import java.util.HashSet;

class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class LinkedList {
    Node head;

    // Insert at end
    public void insert(int data) {
        Node newNode = new Node(data, null);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
    }

    // Find pairs with given sum
    public void findPairsWithSum(int target) {
        if (head == null) return;

        HashSet<Integer> set = new HashSet<>();
        Node temp = head;

        System.out.println("Pairs with sum " + target + ":");

        while (temp != null) {
            int complement = target - temp.data;

            if (set.contains(complement)) {
                System.out.println("(" + complement + ", " + temp.data + ")");
            }

            set.add(temp.data);
            temp = temp.next;
        }
    }

    // Print list
    public void printList() {
        Node t = head;
        while (t != null) {
            System.out.print(t.data + " ");
            t = t.next;
        }
        System.out.println();
    }
}

public class FindPairsInLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insert(1);
        list.insert(5);
        list.insert(7);
        list.insert(-1);
        list.insert(5);

        System.out.print("Linked List: ");
        list.printList();

        int target = 6;

        list.findPairsWithSum(target);
    }
}
