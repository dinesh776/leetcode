package Github._2095DeleteTheMiddleNodeOfALinkedLIst;
//2095. Delete the Middle Node of a Linked List
//https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/
public class DeleteMiddleNodeOfALinkedList {
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



    public static void main(String[] args) {
        int[] h = {1,3,4,7,1,2,6};
        ListNode head=constructLL(h);
//        display(head);
        head=deleteMiddle(head);
        display(head);
    }
    public static ListNode deleteMiddle(ListNode head) {
        if(head==null||head.next==null){
            return null;
        }
        ListNode slow=head,fast=head.next.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode temp=slow.next.next;
        slow.next.next=null;
        slow.next=temp;
        return head;
    }

    // 3ms
    // public ListNode deleteMiddle(ListNode head) {
    //     if(head==null||head.next==null){
    //         return null;
    //     }
    //     ListNode slow=head,fast=head;
    //     while(fast!=null&&fast.next!=null){
    //         slow=slow.next;
    //         fast=fast.next.next;
    //     }
    //     fast=head;
    //     while(fast.next!=slow){
    //         fast=fast.next;
    //     }
    //     fast.next=slow.next;
    //     return head;
    // }
}
