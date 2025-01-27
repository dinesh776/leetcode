package Github._142LinkedListCycle2;

//142. Linked List Cycle II
//https://leetcode.com/problems/linked-list-cycle-ii/description/
public class LinkedListCycle2 {
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
        if(n<0){
            return null;
        }
        ListNode temp=head;
        while(temp!=null){
            if(n==0){
                return temp;
            }
            n--;
            temp=temp.next;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] h = {1,2};
        int pos=0;
        ListNode head=constructLL(h);
        ListNode node1=getNode(head,1);
        ListNode node2=getNode(head,pos);
        node1.next=node2;
        ListNode res=detectCycle(head);
        if(res==node2){
            System.out.println("tail connects to node index "+pos);
        }
        else{
            System.out.println("failed");
        }
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                slow=head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }
        }

        return null;
    }


    // brute
    // public ListNode detectCycle(ListNode head) {
    //     HashMap<ListNode,Integer> map=new HashMap<>();
    //     int i=0;
    //     ListNode mover=head;
    //     while(mover!=null){
    //         if(map.containsKey(mover)){
    //             return mover;
    //         }
    //         map.put(mover,i++);
    //         mover=mover.next;
    //     }
    //     return null;
    // }

}
