class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class ToArray {
    Node head;

    public void covertToLinkedList(int arr[]) {
        head = new Node(arr[0], null);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i], null);
            mover.next = newNode;
            mover = newNode;
        }
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}

public class ArrayToLinkedList {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50 };
        ToArray l = new ToArray();
        l.covertToLinkedList(arr);
        l.print();

    }

}
