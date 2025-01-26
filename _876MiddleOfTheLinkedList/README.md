# Middle of the Linked List

This project contains a Java implementation of the problem ["Middle of the Linked List"](https://leetcode.com/problems/middle-of-the-linked-list/description/) from LeetCode.

## Problem Description
Given the `head` of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

### Example

**Input:**
```text[]
head = [1,2,3,4,5]
```
**Output:**
```text[]
[3,4,5]
```

**Input:**
```text[]
head = [1,2,3,4,5,6]
```
**Output:**
```text[]
[4,5,6]
```

## Approach
### Optimized Approach (Two Pointers)
1. Use two pointers, `slow` and `fast`.
2. Move `slow` one step and `fast` two steps at a time.
3. When `fast` reaches the end, `slow` will be at the middle node.

### Alternate Approach (Brute Force)
1. Traverse the linked list to count the total number of nodes.
2. Calculate the index of the middle node as `count / 2`.
3. Traverse the list again until the middle node is reached and return it.

## Code Example
```java[]
public class MiddleOfTheLinkedList {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
        int[] h = {1, 2, 3, 4, 5, 6};
        ListNode head = constructLL(h);
        display(middleNode(head));
    }

    // Optimized Approach
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Brute Force Approach
    public static ListNode middleNodeBrute(ListNode head) {
        int c = 0;
        ListNode mover = head;
        while (mover != null) {
            c++;
            mover = mover.next;
        }
        int index = c / 2;
        c = 0;
        mover = head;
        while (mover != null) {
            if (c == index) {
                return mover;
            }
            c++;
            mover = mover.next;
        }
        return head;
    }
}
```

## Complexity Analysis
### Optimized Approach
- **Time Complexity:** O(n), where n is the number of nodes in the linked list.
- **Space Complexity:** O(1), as no additional space is used.

### Alternate Approach
- **Time Complexity:** O(n) (counting nodes) + O(n) (finding middle) = O(n).
- **Space Complexity:** O(1).

## How it Works
1. **Optimized:** The `middleNode` function uses two pointers. The `fast` pointer moves twice as fast as the `slow` pointer. By the time `fast` reaches the end, `slow` will be at the middle.
2. **Alternate:** The brute force approach counts the nodes and calculates the middle index before finding the middle node.

## Package Details
This implementation is part of the `Practice` package.

GitHub Repository: `_876MiddleOfTheLinkedList`
