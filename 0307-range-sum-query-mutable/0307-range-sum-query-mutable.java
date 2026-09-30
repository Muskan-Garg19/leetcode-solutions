class NumArray {
    int[] nums;
    int[] tree;
    int n;

    private static void buildTree(int si, int sj, int i, int[] nums, int[] tree) {
        if(si == sj) {
            tree[i] = nums[si];
            return;
        }
        int mid = si + (sj - si) / 2;
        buildTree(si, mid, 2*i+1, nums, tree);
        buildTree(mid+1, sj, 2*i+2, nums, tree);
        tree[i] = tree[2*i+1] + tree[2*i+2];
        return;
    }

    private static void updateUtil(int si, int sj, int[] tree, int i, int diff, int ind) {
        if(ind < si || ind > sj) {
            return;
        }
        tree[i] += diff;
        if(si != sj) {
            int mid = si + (sj - si) / 2;
            updateUtil(si, mid, tree, 2*i+1, diff, ind);
            updateUtil(mid+1, sj, tree, 2*i+2, diff, ind);
        }
    }

    private static int sumRangeUtil(int si, int sj, int[] tree, int qi, int qj, int i) {
        if(sj < qi || si > qj) {
            return 0;
        }
        if(si >= qi && sj <= qj) {
            return tree[i];
        }
        else {
            int mid = si + (sj - si) / 2;
            int left = sumRangeUtil(si, mid, tree, qi, qj, 2*i+1);
            int right = sumRangeUtil(mid+1, sj, tree, qi, qj, 2*i+2);
            return left + right;
        }
    }

    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        this.tree = new int[4 * n];
        buildTree(0, n-1, 0, nums, tree);
    }
    
    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        updateUtil(0, n-1, tree, 0, diff, index);
    }
    
    public int sumRange(int left, int right) {
        return sumRangeUtil(0, n-1, tree, left, right, 0);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */