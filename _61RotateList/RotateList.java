package Github._61RotateList;
//61. Rotate List
//https://leetcode.com/problems/rotate-list/description/
public class RotateList {
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
        int[] h = {1,2,3,4,5};
        int k=2;
        ListNode head=constructLL(h);
        display(head);
        head=rotateRight(head,k);
        display(head);
    }
    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode tail=head;
        int len=1;
        while(tail.next!=null){
            len++;
            tail=tail.next;
        }
        if(k%len==0){
            return head;
        }
        k=k%len;
        ListNode last=findNewLast(head,len-k);
        tail.next=head;
        head=last.next;
        last.next=null;
        return head;
    }
    private static ListNode findNewLast(ListNode head,int index){
        ListNode temp=head;
        while(temp!=null&&index>1){
            --index;
            temp=temp.next;
        }
        return temp;
    }
}
