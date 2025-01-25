package Github._206ReverseLinkedList;
//206. Reverse Linked List
//https://leetcode.com/problems/reverse-linked-list/description/
public class ReverseLinkedList {
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
    private static void display(ListNode head){
        ListNode temp=head;
        while(temp!=null){
            System.out.print(temp.val+" -> ");
            temp=temp.next;
        }
        System.out.println("END");
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
        int[] h = {1,2,3,4,5};
        ListNode head=constructLL(h);
        head=reverseList(head);
        display(head);
    }

    // recursive
    public static ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode newHead=reverseList(head.next);
        ListNode front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }


    // iterative
    // public static ListNode reverseList(ListNode head) {
    //     ListNode temp=head,prev=null;
    //     while(temp!=null){
    //         ListNode front=temp.next;
    //         temp.next=prev;
    //         prev=temp;
    //         temp=front;
    //     }
    //     return prev;
    // }

}
