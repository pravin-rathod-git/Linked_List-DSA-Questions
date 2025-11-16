class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class FindIntersectionPoint {

    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) return null;

        ListNode temp1 = head1;
        ListNode temp2 = head2;

        while (temp1 != temp2) {

            temp1 = (temp1 == null) ? head2 : temp1.next;
            temp2 = (temp2 == null) ? head1 : temp2.next;
        }

        return temp1;  // intersection node OR null
    }

    // Utility to print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // MAIN FUNCTION
    public static void main(String[] args) {

        // Create first linked list: 1 -> 2 -> 3 -> 7 -> 8 -> 9
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode c1 = new ListNode(7);
        ListNode c2 = new ListNode(8);
        ListNode c3 = new ListNode(9);

        a1.next = a2;
        a2.next = a3;
        a3.next = c1;
        c1.next = c2;
        c2.next = c3;

        // Create second linked list: 4 -> 5 -> 7 -> 8 -> 9
        ListNode b1 = new ListNode(4);
        ListNode b2 = new ListNode(5);
        b1.next = b2;
        b2.next = c1; // intersection happens here

        FindIntersectionPoint sol = new FindIntersectionPoint();

        System.out.println("List 1:");
        printList(a1);
        System.out.println("List 2:");
        printList(b1);

        ListNode ans = sol.getIntersectionNode(a1, b1);

        if (ans != null)
            System.out.println("Intersection at node value: " + ans.val);
        else
            System.out.println("No intersection found");
    }
}
