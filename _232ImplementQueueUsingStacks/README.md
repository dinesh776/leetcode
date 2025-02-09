# 232. Implement Queue using Stacks

## Problem Description
Implement a queue using two stacks. The queue should support the following operations:
- `push(x)`: Pushes element `x` to the back of the queue.
- `pop()`: Removes the element from the front of the queue.
- `peek()`: Returns the front element.
- `empty()`: Returns `true` if the queue is empty, `false` otherwise.

[LeetCode Problem Link](https://leetcode.com/problems/implement-queue-using-stacks/description/)

## Solution Approach
The queue is implemented using two stacks:
1. **Push Operation:**
    - Transfer all elements from `s1` to `s2`.
    - Push the new element onto `s1`.
    - Transfer all elements back from `s2` to `s1`.

2. **Pop Operation:**
    - Directly pop from `s1`.

3. **Peek Operation:**
    - Return the top element of `s1`.

4. **Empty Check:**
    - Return `true` if `s1` is empty, otherwise `false`.

## Code Implementation
```java[]
import java.util.Stack;

public class ImplementQueueUsingStacks {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    
    public ImplementQueueUsingStacks() {
    }
    
    public void push(int x) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }
    
    public int pop() {
        return s1.pop();
    }
    
    public int peek() {
        return s1.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}
```

## How It Works
- **Enqueue (`push(x)`)**: Moves all elements to `s2`, pushes `x`, then restores order.
- **Dequeue (`pop()`)**: Pops the top element from `s1`.
- **Peek (`peek()`)**: Returns the top element from `s1` without removing it.
- **Empty (`empty()`)**: Checks if `s1` is empty.

## Complexity Analysis
- **Push Operation:** `O(n)`, as it requires transferring elements between stacks.
- **Pop Operation:** `O(1)`, as it simply pops an element.
- **Peek Operation:** `O(1)`, as it retrieves the top element.
- **Empty Operation:** `O(1)`, as it only checks if `s1` is empty.

## Usage
```java[]
ImplementQueueUsingStacks queue = new ImplementQueueUsingStacks();
queue.push(1);
queue.push(2);
System.out.println(queue.peek()); // Returns 1
System.out.println(queue.pop());  // Returns 1
System.out.println(queue.empty()); // Returns false
```
