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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = {-1, -1};
        int first = -1;
        int sec = -1;
        int i = 1;
        if(head == null || head.next == null || head.next.next == null) {
            return ans;
        }
        ListNode temp = head.next;
        ListNode prev = head; 
        while(temp.next != null) {
            if((temp.val > prev.val && temp.val > temp.next.val) || (temp.val < prev.val && temp.val < temp.next.val)) {
                if(first == -1) {
                    first = i;
                }
                else if(sec == -1) {
                    sec = i;
                    ans[0] = sec - first;
                    ans[1] = sec - first;
                }
                else {
                    ans[0] = Math.min(ans[0], i - sec);
                    sec = i;
                    ans[1] = sec - first; 
                }
            }
            i++;
            prev = temp;
            temp = temp.next;
        }
        return ans;
    }
}