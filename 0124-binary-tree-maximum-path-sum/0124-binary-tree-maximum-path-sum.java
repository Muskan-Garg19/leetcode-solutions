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
    static int ans = Integer.MIN_VALUE;
    private static int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        int rootLeft = left + root.val;
        int rootRight = right + root.val;
        int rootLeftRight = left + right + root.val;
        int returnVal = Math.max(root.val, Math.max(rootLeft, rootRight));
        ans = Math.max(ans, Math.max(rootLeftRight, returnVal));
        return returnVal;
    }
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        helper(root);
        return ans;
    }
}