package Github._138CopyListWithRandomPointer;
//138. Copy List with Random Pointer
//https://leetcode.com/problems/copy-list-with-random-pointer/description/
public class CopyList {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        Node temp=head;
        while(temp!=null){
            Node copy=new Node(temp.val);
            copy.next=temp.next;
            temp.next=copy;
            temp=temp.next.next;
        }

        temp=head;
        while(temp!=null){
            temp.next.random=(temp.random!=null)?temp.random.next:null;
            temp=temp.next.next;
        }

        temp=head;
        Node dummy=new Node(-1);
        Node res=dummy;
        while(temp!=null){
            res.next=temp.next;
            temp.next=temp.next.next;
            res=res.next;
            temp=temp.next;
        }
        return dummy.next;
    }
}
