# Linked List Cycle II

This project contains a Java implementation of the problem ["Linked List Cycle II"](https://leetcode.com/problems/linked-list-cycle-ii/description/) from LeetCode.

## Problem Description
Given the `head` of a linked list, return the node where the cycle begins. If there is no cycle, return `null`.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the `next` pointer. Internally, the cycle's start index is represented by `pos`.

### Example

**Input:**
```text[]
head = [3,2,0,-4], pos = 1
```
**Output:**
```text[]
tail connects to node index 1
```

**Input:**
```text[]
head = [1,2], pos = 0
```
**Output:**
```text[]
tail connects to node index 0
```

**Input:**
```text[]
head = [1], pos = -1
```
**Output:**
```text[]
no cycle
```

## Approaches

### Optimized Approach (Floyd's Cycle Detection Algorithm)
1. Use two pointers, `slow` and `fast`. Initialize both to the head.
2. Move `slow` one step and `fast` two steps at a time.
3. If `slow` and `fast` meet, reset `slow` to the head.
4. Move both pointers one step at a time. The meeting point is the start of the cycle.
5. If `fast` reaches the end, there is no cycle.

### Brute Force Approach
1. Use a `HashMap` to store each visited node.
2. Traverse the linked list, checking if the current node exists in the `HashMap`.
3. If the node exists, it is the start of the cycle.
4. If the traversal completes without a match, there is no cycle.

## Code Example

```java[]
import java.util.HashMap;

public class LinkedListCycle2 {
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
        if (n < 0) {
            return null;
        }
        ListNode temp = head;
        while (temp != null) {
            if (n == 0) {
                return temp;
            }
            n--;
            temp = temp.next;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] h = {1, 2};
        int pos = 0;
        ListNode head = constructLL(h);
        ListNode node1 = getNode(head, 1);
        ListNode node2 = getNode(head, pos);
        node1.next = node2;
        ListNode res = detectCycle(head);
        if (res == node2) {
            System.out.println("tail connects to node index " + pos);
        } else {
            System.out.println("no cycle");
        }
    }

    //optimised
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    // Brute Force Approach
    public static ListNode detectCycleBruteForce(ListNode head) {
        HashMap<ListNode, Integer> map = new HashMap<>();
        int i = 0;
        ListNode mover = head;
        while (mover != null) {
            if (map.containsKey(mover)) {
                return mover;
            }
            map.put(mover, i++);
            mover = mover.next;
        }
        return null;
    }
}
```

## Complexity Analysis

### Optimized Approach
- **Time Complexity:** O(n), where n is the number of nodes in the linked list.
- **Space Complexity:** O(1).

### Brute Force Approach
- **Time Complexity:** O(n), where n is the number of nodes in the linked list.
- **Space Complexity:** O(n), due to the use of a `HashMap`.

## How it Works
1. **Optimized:** The `detectCycle` function uses Floyd's Cycle Detection Algorithm to find the start of the cycle in O(1) space.
2. **Brute Force:** The `detectCycleBruteForce` function uses a `HashMap` to track visited nodes and identify the cycle.

## Package Details
This implementation is part of the `Practice` package.
