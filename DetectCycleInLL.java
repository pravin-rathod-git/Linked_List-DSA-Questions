class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class DetectCycleInLL {

    // Function to detect the start of a cycle in a linked list
    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;

        // Step 1: Detect if a cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;        // move slow by 1
            fast = fast.next.next;   // move fast by 2

            if (slow == fast) {      // cycle detected
                isCycle = true;
                break;
            }
        }

        // No cycle found
        if (!isCycle)
            return null;

        // Step 2: Move fast to head
        fast = head;

        // Step 3: Move both pointers 1 step until they meet
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        // The meeting point is the start of the cycle
        return slow;
    }

    // ---------------------- MAIN METHOD -------------------------
    public static void main(String[] args) {

        // Creating a linked list WITHOUT a cycle
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);

        Solution sol = new Solution();

        ListNode cycleStart1 = sol.detectCycle(head1);
        System.out.println("List 1 cycle start: " +
                           (cycleStart1 == null ? "No Cycle" : cycleStart1.val));



        // Creating a linked list WITH a cycle
        ListNode head2 = new ListNode(10);
        head2.next = new ListNode(20);
        head2.next.next = new ListNode(30);
        head2.next.next.next = new ListNode(40);
        head2.next.next.next.next = new ListNode(50);

        // Creating a cycle: 50 -> 30
        head2.next.next.next.next.next = head2.next.next;

        ListNode cycleStart2 = sol.detectCycle(head2);
        System.out.println("List 2 cycle starts at node value: " +
                           (cycleStart2 == null ? "No Cycle" : cycleStart2.val));
    }
}
