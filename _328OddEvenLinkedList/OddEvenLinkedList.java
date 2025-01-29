package Github._328OddEvenLinkedList;
//328. Odd Even Linked List
//https://leetcode.com/problems/odd-even-linked-list/description/
public class OddEvenLinkedList {
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
        ListNode head=constructLL(h);
        display(head);
        System.out.println("-----------------------");
        head=oddEvenList(head);
        display(head);
    }
    public static ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }

        ListNode odd=head,even=head.next;
        ListNode evenHead=head.next;
        while(even!=null&&even.next!=null){
            odd.next=odd.next.next;
            even.next=even.next.next;
            odd=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;
    }
}
