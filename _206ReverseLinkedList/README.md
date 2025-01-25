# Reverse Linked List - LeetCode Problem 206

## Problem Description
Given the head of a singly linked list, reverse the list, and return the reversed list.

**Link to Problem:** [206. Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/description/)

## Example
### Input:
```
head = [1, 2, 3, 4, 5]
```

### Output:
```
[5, 4, 3, 2, 1]
```

## Solution
This problem can be solved using two approaches:
1. Recursive
2. Iterative

### Recursive Approach
In the recursive method, we traverse to the end of the linked list and reverse the links while returning.

#### Steps:
1. If the `head` is null or there is only one node, return the `head`.
2. Recursively reverse the rest of the list.
3. Adjust the links so that the current node points to its previous node.
4. Set the next pointer of the current node to `null`.

#### Code:
```java[]
public static ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }
    ListNode newHead = reverseList(head.next);
    ListNode front = head.next;
    front.next = head;
    head.next = null;
    return newHead;
}
```

### Iterative Approach
In the iterative method, we reverse the links as we traverse the list.

#### Steps:
1. Initialize two pointers: `prev` as `null` and `temp` as the current `head`.
2. Traverse the list, adjusting the `next` pointer of the current node to point to `prev`.
3. Move the `prev` pointer to the current node and the `temp` pointer to the next node.
4. Continue until the entire list is reversed.

#### Code:
```java[]
public static ListNode reverseList(ListNode head) {
    ListNode temp = head, prev = null;
    while (temp != null) {
        ListNode front = temp.next;
        temp.next = prev;
        prev = temp;
        temp = front;
    }
    return prev;
}
```

## Helper Functions

### Constructing a Linked List
```java[]
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
```

### Displaying a Linked List
```java[]
private static void display(ListNode head) {
    ListNode temp = head;
    while (temp != null) {
        System.out.print(temp.val + " -> ");
        temp = temp.next;
    }
    System.out.println("END");
}
```

### Finding a Node by Value
```java[]
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
```

## Complexity Analysis

### Recursive Approach:
- **Time Complexity:** O(n), where n is the number of nodes in the linked list.
- **Space Complexity:** O(n), due to the recursive call stack.

### Iterative Approach:
- **Time Complexity:** O(n), where n is the number of nodes in the linked list.
- **Space Complexity:** O(1), as no extra space is used.

## Usage
1. Copy the code into a Java IDE.
2. Modify the input array in the `main` method to test different cases.
3. Run the program to see the reversed linked list.

## How It Works
1. The `constructLL` function converts an array into a linked list.
2. The `display` function prints the linked list.
3. The `reverseList` function reverses the linked list either recursively or iteratively based on the implementation.
4. The `main` method demonstrates the usage of the above functions to solve the problem.

