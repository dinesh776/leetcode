package Github._19RemoveNthNode;
//19. Remove Nth Node From End of List
//https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
public class RemoveNthNode {
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
        int[] h = {4,5,1,9};
        ListNode head=constructLL(h);
        display(head);
        int n=2;
        head=removeNthFromEnd(head,n);
        display(head);
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null||head.next==null){
            return null;
        }
        ListNode fast=head;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        ListNode slow=head;
        if(fast==null){
            return head.next;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}
