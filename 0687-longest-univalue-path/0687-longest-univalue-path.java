/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static int ans = 0;

    private static int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        if (root.left != null && root.left.val == root.val) {
            left++;
        } else {
            left = 0;
        }

        if (root.right != null && root.right.val == root.val) {
            right++;
        } else {
            right = 0;
        }

        ans = Math.max(ans, left + right);

        return Math.max(left, right);
    }

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        helper(root);
        return ans;
    }
}