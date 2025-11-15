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

    // Removes Nth node from end using reverse method
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        // Step 1: Reverse the list
        ListNode rev = reverse(head);

        // Step 2: If removing the first node of reversed list
        if (n == 1) {
            rev = rev.next;
            return reverse(rev);
        }

        // Step 3: Reach the (n-1)th node
        ListNode temp = rev;
        int count = 1;

        while (temp != null && temp.next != null && count < n - 1) {
            temp = temp.next;
            count++;    // IMPORTANT: increment count
        }

        // Step 4: Delete nth node
        if (temp != null && temp.next != null) {
            temp.next = temp.next.next;
        }

        // Step 5: Reverse again to restore order
        return reverse(rev);
    }

    // Reverse linked list
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

public class DeleteNthNodeFromLast {

    // Build list from array
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

    // Print list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example list
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = buildList(arr);

        System.out.println("Original list:");
        printList(head);

        Solution sol = new Solution();

        // Remove 2nd node from end
        head = sol.removeNthFromEnd(head, 2);

        System.out.println("After removing 2nd node from end:");
        printList(head);
    }
}
