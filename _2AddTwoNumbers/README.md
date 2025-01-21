# Add Two Numbers

This Java program solves the problem of adding two numbers represented as linked lists. Each node in the linked list contains a single digit, and the digits are stored in reverse order, meaning that the least significant digit comes first. The program returns a linked list representing the sum of the two numbers.

## Problem Description

- **LeetCode Link**: [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/description/)

## Example

```java[]
ListNode last = new ListNode(3, null);
ListNode s2 = new ListNode(4, last);
ListNode s1 = new ListNode(2, s2);
ListNode last1 = new ListNode(4, null);
ListNode s12 = new ListNode(6, last1);
ListNode s11 = new ListNode(5, s12);

ListNode.display(s1); // Output: 2 -> 4 -> 3 -> END
ListNode.display(s11); // Output: 5 -> 6 -> 4 -> END

ListNode result = addTwoNumbers(s1, s11);
ListNode.display(result); // Output: 7 -> 0 -> 8 -> END
```

## Approach

1. **Initialization**:
    - Create a dummy node to simplify result construction.
    - Use a carry variable to handle sums greater than 9.

2. **Iteration**:
    - Traverse through both linked lists, adding corresponding nodes' values and the carry.
    - Create new nodes in the result linked list to store the sum modulo 10.
    - Update the carry for the next iteration.

3. **Termination**:
    - If there is a remaining carry after processing both linked lists, add a new node for it.

4. **Return**:
    - Return the result linked list starting from `dummy.next`.

## Code

```java[]
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode last = new ListNode(3, null);
        ListNode s2 = new ListNode(4, last);
        ListNode s1 = new ListNode(2, s2);
        ListNode last1 = new ListNode(4, null);
        ListNode s12 = new ListNode(6, last1);
        ListNode s11 = new ListNode(5, s12);
        ListNode.display(s1);
        System.out.println();
        ListNode.display(s11);
        System.out.println();
        ListNode node = addTwoNumbers(s1, s11);
        ListNode.display(node);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        // Iterate through the linked lists
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10; // Calculate the carry for the next digit
            current.next = new ListNode(sum % 10); // Store the current digit in the result linked list
            current = current.next; // Move to the next node
        }

        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        
        public static void display(ListNode start) {
            ListNode temp = start;
            while (temp != null) {
                System.out.print(temp.val + " -> ");
                temp = temp.next;
            }
            System.out.print("END");
        }
    }
}
```

## Complexity Analysis

- **Time Complexity**: O(max(m, n)), where `m` and `n` are the lengths of the two linked lists. Each node is visited once.
- **Space Complexity**: O(max(m, n)), for the result linked list.

## How It Works

1. **Example Walkthrough**:
    - Input: `(2 -> 4 -> 3)` and `(5 -> 6 -> 4)`
    - Addition with carry:
        - `2 + 5 = 7`
        - `4 + 6 = 10` (carry 1)
        - `3 + 4 + 1 = 8`
    - Result: `7 -> 0 -> 8`

2. **Edge Cases**:
    - Empty linked list(s).
    - Single-node linked lists.
    - Large numbers causing multiple carries.

## Usage

This program is useful for problems involving large integers where the digits are stored as linked lists. It demonstrates effective handling of carry and edge cases.
