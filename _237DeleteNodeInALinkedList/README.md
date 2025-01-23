# Delete Node in a Linked List

## Problem Description
[237. Delete Node in a Linked List](https://leetcode.com/problems/delete-node-in-a-linked-list/description/)

The problem requires deleting a node in a singly linked list without having access to the head of the list. The solution must modify the linked list in place.

## Example

### Input:
```plaintext[]
Linked List: 4 -> 5 -> 1 -> 9
Node to delete: 1
```

### Output:
```plaintext[]
Linked List after deletion: 4 -> 5 -> 9
```

## Solution

The key idea is to copy the value of the next node into the current node and update the pointer to skip the next node, effectively deleting it.

### Implementation

```java[]
public class DeleteNodeInALinkedList {
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
        ListNode node = getNode(head, 1);
        deleteNode(node);
        display(head);
    }

    public static void deleteNode(ListNode node) {
        ListNode tail = null;
        while (node.next != null) {
            int val = node.next.val;
            node.next.val = node.val;
            node.val = val;
            if (node.next.next == null) {
                tail = node;
            }
            node = node.next;
        }
        tail.next = null;
    }
}
```

### Explanation
1. **Constructing the Linked List**:
   The `constructLL` function creates a linked list from an input array.

2. **Getting the Node to Delete**:
   The `getNode` function finds the node in the linked list that matches the given value.

3. **Deleting the Node**:
    - Copy the value of the next node into the current node.
    - Adjust the pointer to skip the next node.
    - Stop the traversal once the last node is reached, and set the second last node's `next` pointer to `null`.

4. **Displaying the Linked List**:
   The `display` function prints the linked list in a readable format.

## Complexity Analysis

- **Time Complexity**: O(n), where `n` is the number of nodes from the given node to the end of the list. Each node is visited once.
- **Space Complexity**: O(1), as the deletion is performed in place without additional data structures.

## How It Works
The solution leverages the fact that we are given access to the node to delete. By copying the next node's value and skipping it, we effectively "delete" the node. This avoids the need to traverse the list from the head.

## Usage
To test the implementation, call the `main` method. Modify the input array and node value as needed for different test cases.
