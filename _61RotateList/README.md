# Rotate List

## Problem Statement
Given the head of a linked list, rotate the list to the right by `k` places.

LeetCode Problem: [61. Rotate List](https://leetcode.com/problems/rotate-list/description/)

## Example

### Input
```
head = [1,2,3,4,5], k = 2
```

### Output
```
4 -> 5 -> 1 -> 2 -> 3 -> END
```

## Solution Approach
1. **Calculate Length:** Traverse the list to determine its length.
2. **Optimize Rotation:** Since rotating by `len` results in the same list, update `k = k % len`.
3. **Find New Tail:** Identify the new last node (position `len - k`).
4. **Rearrange Pointers:** Make the list circular, update the head, and break the cycle.

## Code Implementation
```java[]
public class RotateList {
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
        int[] h = {1,2,3,4,5};
        int k = 2;
        ListNode head = constructLL(h);
        display(head);
        head = rotateRight(head, k);
        display(head);
    }
    
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }
        k = k % len;
        if (k == 0) {
            return head;
        }
        ListNode last = findNewLast(head, len - k);
        tail.next = head;
        head = last.next;
        last.next = null;
        return head;
    }
    
    private static ListNode findNewLast(ListNode head, int index) {
        ListNode temp = head;
        while (temp != null && index > 1) {
            index--;
            temp = temp.next;
        }
        return temp;
    }
}
```

## Complexity Analysis
- **Time Complexity:** `O(N)`, where `N` is the number of nodes in the list.
- **Space Complexity:** `O(1)`, since no extra space is used apart from pointers.

## Edge Cases Considered
- When `k = 0`, return the original list.
- When `head == null` or `head.next == null`.
- When `k` is greater than the length of the list.
- Handling circular references properly.

## Summary
This implementation efficiently rotates a linked list in `O(N)` time with `O(1)` space, making it an optimal solution.

