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
    private static boolean helper(TreeNode root, TreeNode min, TreeNode max) {
        if(root == null) {
            return true;
        }
        if((min != null && root.val <= min.val) || (max != null && root.val >= max.val)) {
            return false;
        }
        boolean left = helper(root.left, min, root);
        boolean right = helper(root.right, root, max);
        return left && right;
    }
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
}