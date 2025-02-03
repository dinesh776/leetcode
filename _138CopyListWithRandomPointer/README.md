# Copy List with Random Pointer

## Problem Description
This repository contains a solution to the LeetCode problem **138. Copy List with Random Pointer**. The problem statement can be found [here](https://leetcode.com/problems/copy-list-with-random-pointer/description/).

## Solution Approach
The approach used in this implementation follows three main steps:

1. **Clone Nodes & Insert in Original List:**
    - Traverse the list and create a copy of each node.
    - Insert the copied node immediately after the original node.

2. **Assign Random Pointers:**
    - Traverse the list again to update the `random` pointers for the copied nodes.

3. **Separate the Copied List:**
    - Extract the copied nodes to form the final cloned list, restoring the original list structure.

## Code Implementation
```java[]
public class CopyList {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    
    public Node copyRandomList(Node head) {
        Node temp = head;
        
        // Step 1: Create a copy of each node and insert it after the original node
        while (temp != null) {
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = temp.next.next;
        }
        
        // Step 2: Assign random pointers for the copied nodes
        temp = head;
        while (temp != null) {
            temp.next.random = (temp.random != null) ? temp.random.next : null;
            temp = temp.next.next;
        }
        
        // Step 3: Separate the copied list from the original list
        temp = head;
        Node dummy = new Node(-1);
        Node res = dummy;
        while (temp != null) {
            res.next = temp.next;
            temp.next = temp.next.next;
            res = res.next;
            temp = temp.next;
        }
        
        return dummy.next;
    }
}
```

## Complexity Analysis
- **Time Complexity:** O(3N), where N is the number of nodes in the list. Each node is visited a constant number of times.
- **Space Complexity:** O(N), as the copying is done.

## How It Works
1. A copy of each node is inserted right after the original node.
2. Random pointers are assigned correctly using the newly inserted nodes.
3. The cloned list is separated from the original, ensuring both lists maintain their structure.

## Usage
- This method can be used for cloning linked lists that contain random pointers.
- It is useful in scenarios where complex data structures need to be duplicated efficiently.
