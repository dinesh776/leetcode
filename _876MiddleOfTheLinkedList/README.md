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

    public static ListNode middleNode(ListNode head) {
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
- **Time Complexity:**
    - Counting nodes: O(n)
    - Traversing to the middle: O(n)
    - **Total:** O(n)
- **Space Complexity:** O(1) (no additional space used apart from variables).

## How it Works
1. The `constructLL` function creates a linked list from an array of integers.
2. The `middleNode` function first counts the total number of nodes in the linked list.
3. It calculates the middle index and traverses the list again to return the middle node.
4. The `display` function prints the linked list starting from the middle node.
