# Remove Nth Node From End of List

## Problem Description
The problem is to remove the Nth node from the end of a singly linked list and return the modified list.

[LeetCode Problem #19 - Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/)

## Example

### Input:
```java
int[] h = {4,5,1,9};
int n = 2;
```

### Output:
```
4 -> 5 -> 9 -> END
```

## Solution Approach
1. **Use two pointers**: Move `fast` pointer `n` steps ahead.
2. **Move both pointers**: Move `slow` and `fast` together until `fast` reaches the last node.
3. **Remove the node**: Adjust `slow.next` to skip the target node.
4. **Edge cases**: Handle cases where `n` is equal to the length of the list, requiring removal of the head.

## Code Implementation
```java[]
public class RemoveNthNode {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private static ListNode constructLL(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode mover = head;
        for (int i = 1; i < arr.length; i++) {
            mover.next = new ListNode(arr[i]);
            mover = mover.next;
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
        int[] h = {4, 5, 1, 9};
        ListNode head = constructLL(h);
        display(head);
        int n = 2;
        head = removeNthFromEnd(head, n);
        display(head);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        ListNode slow = head;
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
```

## Complexity Analysis
- **Time Complexity**: O(L), where L is the length of the linked list.
- **Space Complexity**: O(1), as we use only two pointers without extra space.

## Usage
This implementation can be used in problems related to linked list manipulations, such as deleting a specific node efficiently in one pass.
