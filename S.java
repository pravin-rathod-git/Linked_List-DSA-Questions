// Definition for singly-linked list node
class ListNode {
    int val;
    ListNode next;

    // Constructor to initialize value
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class DetectCycleL {

    // Function to detect if the linked list has a cycle
    public boolean hasCycle(ListNode head) {

        // If list has 0 or 1 node, it cannot have a cycle
        if (head == null || head.next == null) return false;

        // Fast pointer moves 2 steps, slow pointer moves 1 step
        ListNode fast = head;
        ListNode slow = head;

        // Traverse until fast reaches end
        while (fast != null && fast.next != null) {
            fast = fast.next.next; // move fast by 2
            slow = slow.next;      // move slow by 1

            // If fast and slow meet, a cycle exists
            if (slow == fast) {
                return true;
            }
        }

        // If fast reaches null, no cycle exists
        return false;
    }

    public static void main(String[] args) {

        // ------------------------
        // Example 1: No cycle list
        // ------------------------
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);

        Solution sol = new Solution();
        System.out.println("List 1 has cycle? " + sol.hasCycle(head1));
        // Output: false


        // ------------------------
        // Example 2: List with cycle
        // ------------------------
        ListNode head2 = new ListNode(10);
        head2.next = new ListNode(20);
        head2.next.next = new ListNode(30);
        head2.next.next.next = new ListNode(40);

        // Creating a cycle: last node → second node (40 → 20)
        head2.next.next.next.next = head2.next;

        System.out.println("List 2 has cycle? " + sol.hasCycle(head2));
        // Output: true
    }
}
