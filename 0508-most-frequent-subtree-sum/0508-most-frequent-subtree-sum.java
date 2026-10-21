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
    static int largestFree = Integer.MIN_VALUE;
    private static int helper(TreeNode root, HashMap<Integer, Integer> map) {
        if(root == null) {
            return 0;
        }
        int leftSum = helper(root.left, map);
        int rightSum = helper(root.right, map);
        int totalSum = leftSum + rightSum + root.val;
        map.put(totalSum, map.getOrDefault(totalSum, 0) + 1);
        largestFree = Math.max(largestFree, map.get(totalSum));
        return totalSum;
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        largestFree = Integer.MIN_VALUE;
        helper(root, map);
        ArrayList<Integer> list = new ArrayList<>();
        for(int key : map.keySet()) {
            if(map.get(key) == largestFree) {
                list.add(key);
            }
        }

        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}