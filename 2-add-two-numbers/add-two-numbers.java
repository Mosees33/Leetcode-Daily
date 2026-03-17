/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;
        int carry = 0;

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(t1 != null || t2 != null || carry != 0){
            int n1 = t1 == null ? 0 : t1.val;
            int n2 = t2 == null ? 0 : t2.val;

            int sum = n1 + n2 + carry;
            
            ListNode n = new ListNode(sum % 10);
            temp.next = n;

            t1 = t1 != null ? t1.next : t1;
            t2 = t2 != null ? t2.next : t2;
            temp = temp.next;

            carry = sum > 9 ? 1 : 0;
        }
        return dummy.next;
    }
}