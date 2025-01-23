package Github._237DeleteNodeInALinkedList;
//237. Delete Node in a Linked List
//https://leetcode.com/problems/delete-node-in-a-linked-list/description/
public class DeleteNodeInALinkedList {
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
        int[] h = {4,5,1,9};
        ListNode head=constructLL(h);
//        display(head);
        ListNode node=getNode(head,1);
        deleteNode(node);
        display(head);
    }
    public static void deleteNode(ListNode node) {
        ListNode tail=null;
        while(node.next!=null){
            int val=node.next.val;
            node.next.val=node.val;
            node.val=val;
            if(node.next.next==null){
                tail=node;
            }
            node=node.next;
        }
        tail.next=null;
    }
}
