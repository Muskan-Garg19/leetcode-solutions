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
class BSTIterator {
    TreeNode root;
    Queue<TreeNode> inorder;
    private static void getInorder(TreeNode root, Queue<TreeNode> inorder) {
        if(root == null) {
            return;
        }
        getInorder(root.left, inorder);
        inorder.add(root);
        getInorder(root.right, inorder);
    }
    public BSTIterator(TreeNode root) {
        this.root = root;
        this.inorder = new LinkedList<>();
        getInorder(root, inorder);
    }
    
    public int next() {
        return inorder.remove().val;
    }
    
    public boolean hasNext() {
        return !inorder.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */