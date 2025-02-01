# Reverse Nodes in k-Group

## Problem Description
This project provides a solution to [LeetCode Problem 25: Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/description/). Given a linked list, we reverse the nodes of the list k at a time and return the modified list.

## Example
### Input:
```java[]
head = [1,2,3,4,5], k = 2
```
### Output:
```java[]
[2,1,4,3,5]
```

## Solution Approach
The solution involves the following steps:
1. **Find the kth Node:** Traverse the list to find the kth node. If less than k nodes remain, return the head.
2. **Reverse the first k nodes:** Detach the k nodes and reverse them.
3. **Recursively reverse remaining groups:** Repeat the process for the remaining linked list.
4. **Reattach the reversed groups:** Link the reversed k-group with the remaining list.

## Code Implementation
```java[]
public class ReverseNodesInKGroup {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private static ListNode constructLL(int[] arr) {
        ListNode head=new ListNode(arr[0]);
        ListNode mover=head;
        for(int i=1;i<arr.length;i++){
            ListNode x=new ListNode(arr[i]);
            mover.next=x;
            mover=x;
        }
        return head;
    }

    private static void display(ListNode head){
        ListNode temp=head;
        while(temp!=null){
            System.out.print(temp.val+" -> ");
            temp=temp.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        int[] h = {1,2,3,4,5};
        ListNode head=constructLL(h);
        display(head);
        int k=2;
        head=reverseKGroup(head,k);
        display(head);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode kthNode=getKthNode(head,k);
        if(kthNode==null){
            return head;
        }
        ListNode kthNext=kthNode.next;
        kthNode.next=null;
        ListNode prevHead=head;
        head=reverseList(head);
        prevHead.next=kthNext;

        ListNode temp=kthNext;
        while(temp!=null){
            kthNode=getKthNode(temp,k);
            if(kthNode==null){
                return head;
            }
            kthNext=kthNode.next;
            kthNode.next=null;
            prevHead.next=reverseList(temp);
            prevHead=temp;
            prevHead.next=kthNext;
            temp=kthNext;
        }
        return head;
    }

    private static ListNode getKthNode(ListNode head,int k){
        ListNode temp=head;
        while(temp!=null&&k>1){
            k--;
            temp=temp.next;
        }
        return temp;
    }

    private static ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode newHead=reverseList(head.next);
        ListNode front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }
}
```

## Complexity Analysis
- **Time Complexity:** O(N) - Each node is visited at most twice (once to count and once to reverse).
- **Space Complexity:** O(1) - Only a few extra pointers are used.

