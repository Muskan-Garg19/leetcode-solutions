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
class CBTInserter {
    TreeNode root = null;
    Queue<TreeNode> q;

    private static void insert(TreeNode root, Queue<TreeNode> q) {
        Queue<TreeNode> helper = new LinkedList<>();
        helper.add(root);
        while(!helper.isEmpty()) {
            int size = helper.size();
            for(int i = 0; i < size; i++) {
                TreeNode curr = helper.remove();
                q.add(curr);
                if(curr.left != null) {
                    helper.add(curr.left);
                }
                if(curr.right != null) {
                    helper.add(curr.right);
                }
            }
        }
    }
    public CBTInserter(TreeNode root) {
        this.root = root;
        q = new LinkedList<>();
        insert(root, q);
    }
    
    public int insert(int val) {
        TreeNode newNode = new TreeNode(val);
        while(!q.isEmpty() && q.peek().left != null && q.peek().right != null) {
            q.remove();
        }
        if(q.peek().left == null) {
            q.peek().left = newNode;
        }
        else {
            q.peek().right = newNode;
        }
        q.add(newNode);
        return q.peek().val;
    }
    
    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */