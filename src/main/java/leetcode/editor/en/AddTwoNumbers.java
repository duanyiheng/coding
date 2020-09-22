package leetcode.editor.en;
//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order and each of their nodes contain a sing
//le digit. Add the two numbers and return it as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// Example: 
//
// 
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.
// 
// Related Topics Linked List Math 
// 👍 9282 👎 2339

public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode res;
            ListNode cur = new ListNode();
            res = cur;
            ListNode next;
            ListNode pre = cur;
            int carry = 0;
            while (l1 != null && l2 != null) {
                cur.val = (l1.val + l2.val + carry) % 10;
                carry = (l1.val + l2.val + carry) / 10;
                l1 = l1.next;
                l2 = l2.next;
                next = new ListNode();
                cur.next = next;
                pre = cur;
                cur = next;
            }
            while (l1 != null) {
                cur.val = (l1.val + carry) % 10;
                carry = (l1.val + carry) / 10;
                l1 = l1.next;
                next = new ListNode();
                cur.next = next;
                pre = cur;
                cur = next;
            }
            while (l2 != null) {
                cur.val = (l2.val + carry) % 10;
                carry = (l2.val + carry) / 10;
                l2 = l2.next;
                next = new ListNode();
                cur.next = next;
                pre = cur;
                cur = next;
            }
            if (carry > 0) {
                cur.val = 1;
                cur.next = null;
            } else {
                pre.next = null;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

