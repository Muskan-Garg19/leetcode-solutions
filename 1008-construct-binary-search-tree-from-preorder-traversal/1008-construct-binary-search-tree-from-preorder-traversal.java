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
    private static TreeNode helper(int[] preorder, int[] i, TreeNode left, TreeNode right) {
        if(i[0] >= preorder.length || (left != null && preorder[i[0]] <= left.val) || (right != null && preorder[i[0]] >= right.val)) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[i[0]]);
        i[0] += 1;
        root.left = helper(preorder, i, left, root);
        root.right = helper(preorder, i, root, right);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] i = new int[1];
        return helper(preorder, i, null, null);
    }
}