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
    class Pair {
        TreeNode node;
        int nodeVal;
        Pair(TreeNode node, int nodeVal) {
            this.node = node;
            this.nodeVal = nodeVal;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        int width = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()) {
            int start = q.peek().nodeVal;
            int end = start;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Pair p = q.remove();
                end = p.nodeVal;
                if(p.node.left != null) {
                    q.add(new Pair(p.node.left, (2 * end + 1)));
                }
                if(p.node.right != null) {
                    q.add(new Pair(p.node.right, (2 * end + 2)));
                }
            }
            width = Math.max(width, (end - start + 1));
        }
        return width;
    }
}