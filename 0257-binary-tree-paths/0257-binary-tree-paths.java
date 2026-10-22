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
    private static void helper(TreeNode root, List<String> ans, StringBuilder sb) {
        if(root == null) {
            return;
        }
        int len = sb.length();
        sb.append(root.val);
        sb.append("->");
        if(root.left == null && root.right == null) {
            int end = sb.length() - 2;
            String sub = sb.substring(0, end);
            ans.add(sub);
        }
        helper(root.left, ans, sb);
        helper(root.right, ans, sb);
        sb.setLength(len);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        helper(root, ans, new StringBuilder());
        return ans;
    }
}