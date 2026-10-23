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
    private static void helper(TreeNode root, int[] arr, int k) {
        if(root == null) {
            return;
        }
        helper(root.left, arr, k);
        if(arr[0] < k) {
            arr[0] += 1;
            arr[1] = root.val;
        }
        helper(root.right, arr, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        int[] arr = new int[2];
        helper(root, arr, k);
        return arr[1];
    }
}