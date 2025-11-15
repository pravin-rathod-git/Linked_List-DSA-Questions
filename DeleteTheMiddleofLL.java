class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { 
        this.val = val; 
    }
    ListNode(int val, ListNode next) { 
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode deleteMiddle(ListNode head) {

        // If list has 0 or 1 node → middle is head itself
        if (head == null || head.next == null) 
            return null;

        ListNode fast = head;
        ListNode slow = head;

        // Move fast two steps and slow one step
        fast = fast.next.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // slow.next is middle node → delete it
        slow.next = slow.next.next;

        return head;
    }
}

public class DeleteTheMiddleofLL {

    // Build linked list from array
    public static ListNode buildList(int[] arr) {
        if (arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;

        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    // Print linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = buildList(arr);

        System.out.println("Original List:");
        printList(head);

        Solution sol = new Solution();
        head = sol.deleteMiddle(head);

        System.out.println("After deleting middle node:");
        printList(head);
    }
}
