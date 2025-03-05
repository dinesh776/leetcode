package Github._2AddTwoNumbers;
//Add Two Numbers
//https://leetcode.com/problems/add-two-numbers/description/
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode last=new ListNode(3,null);
        ListNode s2=new ListNode(4,last);
        ListNode s1=new ListNode(2,s2);
        ListNode last1=new ListNode(4,null);
        ListNode s12=new ListNode(6,last1);
        ListNode s11=new ListNode(5,s12);
        ListNode.display(s1);
        System.out.println();
        ListNode.display(s11);
        System.out.println();
        ListNode node=addTwoNumbers(s1,s11);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        // Iterate through the linked lists
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10; // Calculate the carry for the next digit
            current.next = new ListNode(sum % 10); // Store the current digit in the result linked list
            current = current.next; // Move to the next node
        }

        return dummy.next;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        public static void display(ListNode start){
            ListNode temp=start;
            while(temp!=null){
                System.out.print(temp.val+" -> ");
                temp=temp.next;
            }
            System.out.print("END");
        }
    }
}
