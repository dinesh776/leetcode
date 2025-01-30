# Delete the Middle Node of a Linked List

## Problem Statement
Given the head of a singly linked list, delete the middle node and return the modified list. If there are two middle nodes, delete the second one.

**LeetCode Problem:** [2095. Delete the Middle Node of a Linked List](https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/)

## Approach
The solution uses the **slow and fast pointer technique** to identify the middle node efficiently.

1. If the list is empty or has only one node, return `null`.
2. Use two pointers:
    - `slow` moves one step at a time.
    - `fast` moves two steps at a time.
3. When `fast` reaches the end, `slow` will be at the middle.
4. Remove the middle node by adjusting pointers.

## Code Implementation

```java[]
public class DeleteMiddleNodeOfALinkedList {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private static ListNode constructLL(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode mover = head;
        int n = arr.length;
        for (int i = 1; i < n; i++) {
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
        int[] h = {1, 3, 4, 7, 1, 2, 6};
        ListNode head = constructLL(h);
        head = deleteMiddle(head);
        display(head);
    }

    public static ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next.next;
        slow.next = temp;
        return head;
    }
}
```

## Alternative Approach (3ms Solution)
Another approach keeps track of the previous node before the middle node and deletes it directly:

```java[]
public ListNode deleteMiddle(ListNode head) {
    if (head == null || head.next == null) {
        return null;
    }
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    fast = head;
    while (fast.next != slow) {
        fast = fast.next;
    }
    fast.next = slow.next;
    return head;
}
```

## Complexity Analysis
- **Time Complexity:** `O(N)`, where `N` is the number of nodes in the list (single traversal).
- **Space Complexity:** `O(1)`, since we use only a few extra pointers.

## Example Walkthrough
### Input
```java[]
1 -> 3 -> 4 -> 7 -> 1 -> 2 -> 6 -> END
```
### Output
```java[]
1 -> 3 -> 4 -> 1 -> 2 -> 6 -> END
```

## Summary
- Uses **slow and fast pointer** to find the middle.
- Efficient **O(N) time complexity**.
- **O(1) space complexity**.
- Alternative approach included for better performance.

This solution efficiently deletes the middle node from a linked list while maintaining simplicity and optimal performance.
