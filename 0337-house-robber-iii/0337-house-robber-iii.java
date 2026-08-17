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
    private static int helper(TreeNode root, HashMap<TreeNode, Integer> map) {
        if(root == null) {
            return 0;
        }
        if(map.containsKey(root)) {
            return map.get(root);
        }
        //include root node 
        int left = 0;
        int right = 0;
        if(root.left != null) {
            left = helper(root.left.left, map) + helper(root.left.right, map);
        }
        if(root.right != null) {
            right = helper(root.right.left, map) + helper(root.right.right, map);
        }
        int include = left + right + root.val;

        //exclude root node
        int exclude = helper(root.left, map) + helper(root.right, map);
        int ans = Math.max(include, exclude);
        map.put(root, ans);
        return ans;
    }
    
    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> map = new HashMap<>();
        return helper(root, map);
    }
}