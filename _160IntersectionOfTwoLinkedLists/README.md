# Intersection of Two Linked Lists

## Problem Description
Given the heads of two singly linked lists, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return `null`.

**LeetCode Problem:** [160. Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists/description/)

## Example
### Input:
```java[]
List A: 4 -> 1 -> 8 -> 4 -> 5
List B: 5 -> 6 -> 1 -> 8 -> 4 -> 5
```
### Output:
```java[]
8 -> 4 -> 5
```

## Approach
### Two Pointer Approach:
1. Use two pointers, `t1` starting at `headA` and `t2` starting at `headB`.
2. Traverse both lists. When a pointer reaches the end of a list, redirect it to the head of the other list.
3. If there is an intersection, both pointers will eventually meet at the intersection node.
4. If there is no intersection, both pointers will eventually be `null` at the same time.

### Time Complexity:
- **O(m + n)** where `m` and `n` are the lengths of the two linked lists.

### Space Complexity:
- **O(1)** since we are using only two extra pointers.

## Code Implementation (Java)
```java[]
public class IntersectionOf2LinkedLists {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private static ListNode constructLL(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode mover = head;
        for(int i = 1; i < arr.length; i++) {
            mover.next = new ListNode(arr[i]);
            mover = mover.next;
        }
        return head;
    }
    
    private static ListNode getNode(ListNode head, int n) {
        ListNode temp = head;
        while(temp != null) {
            if(temp.val == n) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode t1 = headA, t2 = headB;
        while (t1 != t2) {
            t1 = (t1 == null) ? headB : t1.next;
            t2 = (t2 == null) ? headA : t2.next;
        }
        return t1;
    }
    
    public static void main(String[] args) {
        int[] h1 = {4, 1};
        int[] h2 = {5, 6, 1, 8, 4, 5};
        ListNode head1 = constructLL(h1);
        ListNode head2 = constructLL(h2);
        ListNode tail = getNode(head1, 1);
        ListNode node = getNode(head2, 8);
        tail.next = node;
        ListNode intersection = getIntersectionNode(head1, head2);
        System.out.println(intersection != null ? "Intersection at node value: " + intersection.val : "No Intersection");
    }
}
```

## Alternative Approach (Using HashSet)
### Steps:
1. Traverse one list and store nodes in a HashSet.
2. Traverse the second list and check if any node is already in the HashSet.
3. The first match found is the intersection node.

### Time Complexity:
- **O(m + n)** (Traversing both lists)

### Space Complexity:
- **O(m)** or **O(n)** (Extra space for storing nodes)

```java[]
import java.util.HashSet;

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    HashSet<ListNode> visited = new HashSet<>();
    while (headA != null) {
        visited.add(headA);
        headA = headA.next;
    }
    while (headB != null) {
        if (visited.contains(headB)) {
            return headB;
        }
        headB = headB.next;
    }
    return null;
}
```

## Summary
- **Two Pointer Method:** O(1) space, O(m + n) time.
- **HashSet Method:** O(m) space, O(m + n) time.

This problem is commonly asked in technical interviews. Understanding both approaches can help in optimizing solutions based on constraints. 🚀

