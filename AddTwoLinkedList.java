// Definition for singly-linked list.
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        ListNode t1 = l1;
        ListNode t2 = l2;

        int carry = 0;

        while (t1 != null || t2 != null) {
            int sum = carry;

            if (t1 != null) sum += t1.val;
            if (t2 != null) sum += t2.val;

            carry = sum / 10;

            ListNode node = new ListNode(sum % 10);
            temp.next = node;
            temp = node;

            if (t1 != null) t1 = t1.next;
            if (t2 != null) t2 = t2.next;
        }

        if (carry != 0) {
            temp.next = new ListNode(carry);
        }

        return dummy.next;
    }

    // Helper to print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // Helper to create linked list from array
    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        for (int x : arr) {
            temp.next = new ListNode(x);
            temp = temp.next;
        }

        return dummy.next;
    }

    // Main method
    public static void main(String[] args) {
        Solution obj = new Solution();

        // Example numbers: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        int[] num1 = {2, 4, 3};
        int[] num2 = {5, 6, 4};

        ListNode l1 = createList(num1);
        ListNode l2 = createList(num2);

        System.out.print("L1: ");
        printList(l1);

        System.out.print("L2: ");
        printList(l2);

        ListNode result = obj.addTwoNumbers(l1, l2);

        System.out.print("Result: ");
        printList(result);
    }
}
