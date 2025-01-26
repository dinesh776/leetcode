package Github._876MiddleOfTheLinkedList;
//876. Middle of the Linked List
//https://leetcode.com/problems/middle-of-the-linked-list/description/
public class MiddleOfTheLinkedList {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
        int[] h = {1,2,3,4,5,6};
        ListNode head=constructLL(h);
        display(middleNode(head));
    }
    public static ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    // brute
    // public ListNode middleNode(ListNode head) {
    //     int c=0;
    //     ListNode mover=head;
    //     while(mover!=null){
    //         c++;
    //         mover=mover.next;
    //     }
    //     int index=c/2;
    //     c=0;
    //     mover=head;
    //     while(mover!=null){
    //         if(c==index){
    //             return mover;
    //         }
    //         c++;
    //         mover=mover.next;
    //     }
    //     return head;
    // }

}
