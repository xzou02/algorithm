You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

        You may assume the two numbers do not contain any leading zero, except the number 0 itself.

        Example:

        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        Output: 7 -> 0 -> 8
        Explanation: 342 + 465 = 807.



public class addtwonumbers {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            //create dumbhead
            ListNode dumbhead = new ListNode(0);
            ListNode curr = dumbhead;
            int carry = 0;
            //not modify l1 l2
            ListNode p = l1; ListNode q = l2;

            while(p != null || q != null){
                int x = (p != null) ? p.val : 0;
                int y = (q != null) ? q.val : 0;
                int sum = x + y + carry;
                carry = sum / 10;
                curr.next = new ListNode(sum % 10);
                //increase curr pointer
                curr = curr.next;
                //take care of null node
                if (p != null) p = p.next;
                if (q != null) q = q.next;
            }
            if(carry != 0 ){
                curr.next = new ListNode(1);
            }
            //real list
            return dumbhead.next;
        }

}
