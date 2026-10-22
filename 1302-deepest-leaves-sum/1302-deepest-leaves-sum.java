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
    static int largest = 0;
    private static void helper(TreeNode root, int depth, HashMap<Integer, Integer> map) {
        if(root == null) {
            return;
        }
        helper(root.left, depth + 1, map);
        helper(root.right, depth + 1, map);
        if(root.left == null && root.right == null) {
            largest = Math.max(largest, depth);
            map.put(depth, map.getOrDefault(depth, 0) + root.val);
        }
        return;
    }
    public int deepestLeavesSum(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        largest = 0;
        helper(root, 0, map);
        return map.get(largest);
    }
}