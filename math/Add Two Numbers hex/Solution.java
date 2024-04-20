/**
 * ListNode {
 * String val;
 * ListNode next;
 * ListNode() {}
 * ListNode(String val) { this.val = val; }
 * ListNode(String val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var head = new ListNode();
        var currentNode = head;
        var over = "0";
        var total = "0";

        while(l1 != null || l2 != null || !"0".equals(over)) {
            total = over;
            if (l1 != null) {
                total = sum(total, l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                total = sum(total, l2.val);
                l2 = l2.next;
            }

            over = div16(total);
            currentNode.next = new ListNode(mod16(total));
            currentNode = currentNode.next;
        }
        return head.next;
    }

    private String sum(String a, String b) {
        int sum = Integer.parseInt(a, 16) + Integer.parseInt(b, 16);
        return Integer.toHexString(sum);
    }

    private String div16(String a) {
        int val = Integer.parseInt(a, 16) / 16;
        return Integer.toHexString(val);
    }

    private String mod16(String a) {
        int val = Integer.parseInt(a, 16) % 16;
        return Integer.toHexString(val);
    }
}
