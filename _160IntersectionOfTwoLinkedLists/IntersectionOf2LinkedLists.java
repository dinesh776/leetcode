package Github._160IntersectionOfTwoLinkedLists;
//160. Intersection of Two Linked Lists
//https://leetcode.com/problems/intersection-of-two-linked-lists/description/
public class IntersectionOf2LinkedLists {
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
        int[] h1 = {4,1};
        int[] h2 = {5,6,1,8,4,5};
        ListNode head1=constructLL(h1);
        ListNode head2=constructLL(h2);
        ListNode tail=getNode(head1,1);
        ListNode node=getNode(head2,8);
        tail.next=node;
        ListNode intersection=getIntersectionNode(head1,head2);
        display(intersection);
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode t1=headA,t2=headB;
        while(t1!=t2){
            t1=t1.next;
            t2=t2.next;
            if(t1==t2){
                return t1;
            }
            if(t1==null){
                t1=headB;
            }
            if(t2==null){
                t2=headA;
            }
        }
        return t1;
    }
}
