# Linked List Cycle

## Problem Description
This program solves the problem of detecting a cycle in a linked list. A cycle exists if some node in the list can be reached again by continuously following the `next` pointer. The function determines if there is a cycle using Floyd's Tortoise and Hare algorithm.

LeetCode Problem: [141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/description/)

---

## Example

### Input
Given the linked list:
```java[]
4 -> 5 -> 1 -> 9
          ^    |
          |____|
```

### Output
```java[]
true
```

---

## Solution

### Algorithm
- Use two pointers: `slow` and `fast`.
- Move `slow` by one step and `fast` by two steps.
- If `slow` and `fast` meet, a cycle exists.
- If `fast` reaches the end of the list, no cycle exists.

### Time Complexity
- **O(n)**: Each node is visited at most twice.

### Space Complexity
- **O(1)**: Only two pointers are used.

---

## Code

```java[]
public class LinkedListCycle {
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

    private static ListNode getNode(ListNode head, int n) {
        ListNode temp = head;
        while (temp != null) {
            if (temp.val == n) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] h = {4, 5, 1, 9};
        ListNode head = constructLL(h);
        ListNode node1 = getNode(head, 9);
        ListNode node2 = getNode(head, 5);
        node1.next = node2; // Creates a cycle
        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
```

---

## Usage
1. Construct a linked list using the `constructLL` method.
2. Optionally, create a cycle by connecting a node to an earlier node using the `getNode` method.
3. Use the `hasCycle` method to detect if a cycle exists.

---

## Complexity Analysis
| Time Complexity | Space Complexity |
|-----------------|------------------|
| O(n)            | O(1)             |

---
