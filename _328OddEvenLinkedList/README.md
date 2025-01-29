# Odd Even Linked List

This project contains a Java implementation of the problem ["Odd Even Linked List"](https://leetcode.com/problems/odd-even-linked-list/description/) from LeetCode.

## Problem Description
Given the `head` of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

### Example

**Input:**
```text[]
head = [1,2,3,4,5]
```
**Output:**
```text
[1,3,5,2,4]
```

## Approach
### Optimized Approach
1. Maintain two pointers: `odd` for odd-indexed nodes and `even` for even-indexed nodes.
2. Traverse the list and rearrange the connections accordingly.
3. Attach the even list after the odd list.

## Code Example
```java[]
public class OddEvenLinkedList {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private static ListNode constructLL(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode mover = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode x = new ListNode(arr[i]);
            mover.next = x;
            mover = x;
        }
        return head;
    }

    private static void display(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        int[] h = {1, 2, 3, 4, 5};
        ListNode head = constructLL(h);
        display(head);
        System.out.println("-----------------------");
        head = oddEvenList(head);
        display(head);
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head, even = head.next;
        ListNode evenHead = head.next;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
```

## Complexity Analysis
- **Time Complexity:** O(n), where n is the number of nodes in the linked list.
- **Space Complexity:** O(1), as no additional space is used.

## How it Works
1. The `oddEvenList` function iterates through the list, separating nodes into odd and even lists.
2. Finally, it connects the odd list to the even list to maintain order.
