# Sort List (LeetCode 148)

## Problem Description
Given the head of a linked list, return the list after sorting it in ascending order.

**Link to the problem:** [Sort List - LeetCode](https://leetcode.com/problems/sort-list/description/)

## Solution Overview
This implementation uses the Merge Sort algorithm to sort a linked list. The solution breaks the list into halves, sorts each half recursively, and then merges the sorted halves.

## Code Structure

- **Package:** `U_Github`
- **Class:** `SortList`
- **Helper Class:** `ListNode` (for linked list nodes)

### Code Implementation

```java[]
package U_Github;

public class SortList {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private static ListNode constructLL(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode mover = head;
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            ListNode x = new ListNode(arr[i]);
            mover.next = x;
            mover = x;
        }
        return head;
    }

    private static void display(ListNode head) {
        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        int[] h = {4, 2, 1, 3};
        ListNode head = constructLL(h);
        display(head);
        head = sortList(head);
        display(head);
    }

    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode middle = middle(head);
        ListNode leftHead = head;
        ListNode rightHead = middle.next;
        middle.next = null;
        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);
        return merge(leftHead, rightHead);
    }

    private static ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                temp.next = list1;
                temp = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                temp = list2;
                list2 = list2.next;
            }
        }
        if(list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }
        return dummy.next;
    }

    private static ListNode middle(ListNode head) {
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
```

## Example

**Input:**
```[]
[4, 2, 1, 3]
```

**Output:**
```[]
4 -> 2 -> 1 -> 3 -> END
1 -> 2 -> 3 -> 4 -> END
```

## How It Works
1. The list is divided into halves using the `middle` method.
2. Each half is sorted recursively.
3. The sorted halves are merged using the `merge` method.

## Complexity Analysis
- **Time Complexity:** `O(n log n)` — due to the divide-and-conquer approach of merge sort.
- **Space Complexity:** `O(1)` (in-place merging, but recursive stack space).

## Usage
Compile and run the code with:

```bash[]
javac SortList.java
java SortList
```


