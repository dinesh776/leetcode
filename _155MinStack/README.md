# Min Stack
### LeetCode Link: [Min Stack Problem](https://leetcode.com/problems/min-stack/)
## Problem Description
The **Min Stack** problem requires the implementation of a stack that supports the following operations efficiently:
- **push(x)**: Pushes the element x onto the stack.
- **pop()**: Removes the element on the top of the stack.
- **top()**: Gets the top element of the stack.
- **getMin()**: Retrieves the minimum element in the stack.

The challenge is to implement these operations in constant time **O(1)**.

## Example
```java[]
MinStack obj = new MinStack();
obj.push(-2);
obj.push(0);
obj.push(-3);
System.out.println(obj.getMin()); // Output: -3
obj.pop();
System.out.println(obj.top());    // Output: 0
System.out.println(obj.getMin()); // Output: -2
```

## Solution
The approach uses two stacks:
1. **Main Stack** (`stack`): Stores all elements as they are pushed.
2. **Min Stack** (`minStack`): Maintains the minimum elements.

### Algorithm
- When pushing an element, push it onto the `stack`.
- If the `minStack` is empty or the new element is less than or equal to the top of `minStack`, push it onto `minStack`.
- When popping, if the top element of `stack` matches the top of `minStack`, pop it from `minStack` as well.
- `top()` simply returns the top element of `stack`.
- `getMin()` returns the top element of `minStack`.

## Code Implementation
```java[]
import java.util.Stack;

public class MinStack {
    private Stack<Integer> minStack;
    private Stack<Integer> stack;
    
    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
```

## Complexity Analysis
- **push(x)**: **O(1)** – Both `stack` and `minStack` operations take constant time.
- **pop()**: **O(1)** – Removing elements from both stacks is constant time.
- **top()**: **O(1)** – Accessing the top of a stack takes constant time.
- **getMin()**: **O(1)** – Retrieving the top of `minStack` is constant time.

## Usage
```java[]
MinStack obj = new MinStack();
obj.push(5);
obj.push(2);
System.out.println(obj.getMin()); // Output: 2
obj.pop();
System.out.println(obj.getMin()); // Output: 5
```

## Summary
This implementation ensures that all operations run in constant time **O(1)**, making it an optimal solution for the Min Stack problem on LeetCode.

---


