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

    // Function to sort the linked list using Merge Sort
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) 
            return head;

        // Step 1: Find middle
        ListNode mid = findMid(head);
        ListNode rightHead = mid.next;
        mid.next = null;  // break the list into two halves

        // Step 2: Recursively sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // Step 3: Merge the sorted halves
        return merge(left, right);
    }

    // Function to find middle (slow-fast approach)
    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Merge two sorted linked lists
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        if (l1 != null) temp.next = l1;
        if (l2 != null) temp.next = l2;

        return dummy.next;
    }

    // Print List
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // MAIN FUNCTION
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Creating the linked list: 4 -> 2 -> 1 -> 3
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        System.out.print("Original List: ");
        printList(head);

        // Sorting the list
        head = sol.sortList(head);

        System.out.print("Sorted List:   ");
        printList(head);
    }
}
