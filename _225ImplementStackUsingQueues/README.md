# 225. Implement Stack using Queues

## Problem Description
Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all standard stack operations (push, pop, top, and empty).

[LeetCode Problem Link](https://leetcode.com/problems/implement-stack-using-queues/description/)

## Example
```java[]
MyStack stack = new MyStack();
stack.push(1);
stack.push(2);
System.out.println(stack.top());   // Returns 2
System.out.println(stack.pop());   // Returns 2
System.out.println(stack.empty()); // Returns false
```

## Solution
We use a single queue to simulate the stack operations. When pushing an element, we rotate all existing elements behind it to maintain the LIFO order.

## Code
```java[]
import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> q;
    
    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        int s = q.size();
        q.add(x);
        for (int i = 0; i < s; i++) {
            q.add(q.remove());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
```

## How It Works
- **Push:** Add the new element to the queue and rotate the previous elements behind it to simulate stack behavior.
- **Pop:** Remove the front element of the queue, which represents the top of the stack.
- **Top:** Return the front element without removing it.
- **Empty:** Check if the queue is empty.

## Complexity Analysis
- **Push:** O(n) (Reordering elements in the queue)
- **Pop:** O(1) (Removing the front element)
- **Top:** O(1) (Fetching the front element)
- **Empty:** O(1) (Checking if queue is empty)
