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
    int ans = 0;
    private int[] helper(TreeNode root) {
        if(root == null) {
            return new int[]{0, 0};
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int totalNodes = left[0] + right[0] + 1;
        int sum = left[1] + right[1] + root.val;
        if(sum / totalNodes == root.val) {
            ans++;
        }
        return new int[]{totalNodes, sum};
    }
    public int averageOfSubtree(TreeNode root) {
        ans = 0;
        int[] arr = helper(root);
        return ans;
    }
}