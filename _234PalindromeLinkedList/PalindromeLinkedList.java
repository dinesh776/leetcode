package Github._234PalindromeLinkedList;
//234. Palindrome Linked List
//https://leetcode.com/problems/palindrome-linked-list/description/
public class PalindromeLinkedList {
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
        int[] h = {1,2,2,1};
        ListNode head=constructLL(h);
        System.out.println(isPalindrome(head));
    }
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }
        ListNode slow = head,fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow= slow.next;
            fast= fast.next.next;
        }
        ListNode newHead = reverse(slow.next);
        ListNode first = head;
        ListNode second = newHead;
        while(second != null) {
            if(first.val != second.val) {
                reverse(newHead) ;
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverse(newHead) ;
        return true;
    }
    private static ListNode reverse(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode newHead=reverse(head.next);
        ListNode front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }
}
