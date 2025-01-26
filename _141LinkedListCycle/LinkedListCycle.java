package Github._141LinkedListCycle;
//141. Linked List Cycle
//https://leetcode.com/problems/linked-list-cycle/description/
public class LinkedListCycle {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private static ListNode constructLL(int[] arr) {
        // code here
        ListNode head=new ListNode(arr[0]);
        ListNode mover=head;
        int n=arr.length;
        for(int i=1;i<n;i++){
            ListNode x=new ListNode(arr[i]);
            mover.next=x;
            mover=x;
        }
        return head;
    }

    private static ListNode getNode(ListNode head,int n){
        ListNode temp=head;
        while(temp!=null){
            if(temp.val==n){
                return temp;
            }
            temp=temp.next;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] h = {4,5,1,9};
        ListNode head=constructLL(h);
        ListNode node1=getNode(head,9);
        ListNode node2=getNode(head,5);
        node1.next=node2;
        System.out.println(hasCycle(head));
    }
    public static boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}
