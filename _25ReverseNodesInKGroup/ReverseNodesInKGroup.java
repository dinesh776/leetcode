package Github._25ReverseNodesInKGroup;
//25. Reverse Nodes in k-Group
//https://leetcode.com/problems/reverse-nodes-in-k-group/description/
public class ReverseNodesInKGroup {
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

        // remaining
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
