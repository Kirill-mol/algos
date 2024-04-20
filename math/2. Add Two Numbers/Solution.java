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
        var head = new ListNode();
        var currentNode = head;
        var over = 0;
        var total = 0;

        while (l1 != null || l2 != null || over != 0) {
            total = over;
            if (l1 != null) {
                total += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                total += l2.val;
                l2 = l2.next;
            }

            over = total / 10;
            currentNode.next = new ListNode(total % 10);
            currentNode = currentNode.next;
        }
        return head.next;
    }
}