# Palindrome Linked List

This project provides a Java implementation for solving the problem ["Palindrome Linked List"](https://leetcode.com/problems/palindrome-linked-list/description/) from LeetCode.

## Problem Description
Given the `head` of a singly linked list, determine if it is a palindrome.

### Example

**Input:**
```text[]
head = [1,2,2,1]
```
**Output:**
```text[]
true
```

**Input:**
```text[]
head = [1,2]
```
**Output:**
```text[]
false
```

## Approaches
### Optimized Approach (Two Pointers and Reverse)
1. Use the two-pointer technique to find the middle of the linked list.
2. Reverse the second half of the linked list.
3. Compare the first half with the reversed second half.
4. Reverse the second half back to restore the original list.
5. If all elements match, the list is a palindrome.

### Brute Force Approach
1. Traverse the linked list and store its elements in an ArrayList.
2. Use two pointers to check if the list is a palindrome by comparing elements from the start and end.

## Code Example
```java[]
public class PalindromeLinkedList {
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
        int[] h = {1, 2, 2, 1};
        ListNode head = constructLL(h);
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = reverse(slow.next);
        ListNode first = head;
        ListNode second = newHead;
        while (second != null) {
            if (first.val != second.val) {
                reverse(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverse(newHead);
        return true;
    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
}
```

## Complexity Analysis
### Optimized Approach
- **Time Complexity:** O(n), where n is the number of nodes in the linked list.
- **Space Complexity:** O(1), as the reverse operation is done in place.

### Brute Force Approach
- **Time Complexity:** O(n), for traversing the list.
- **Space Complexity:** O(n), for storing the list elements.

## How It Works
1. The `isPalindrome` function uses two pointers to find the middle of the linked list.
2. The `reverse` function reverses the second half of the list to compare it with the first half.
3. If all corresponding nodes match, the list is a palindrome.

## Package Details
This implementation is part of the `Practice` package.

GitHub Repository: `_234PalindromeLinkedList`
