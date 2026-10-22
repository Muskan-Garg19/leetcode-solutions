class KthLargest {
    int k = 0;
    ArrayList<Integer> list;
    private static void getInd(int val, int low, int high, int[] ind, ArrayList<Integer> list) {
        while(low <= high) {
            int mid = (low + high) / 2;
            if(list.get(mid) <= val) {
                ind[0] = mid + 1;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
    }
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
    }
    
    public int add(int val) {
        int[] ind = new int[1];
        ind[0] = 0;
        getInd(val, 0, list.size() - 1, ind, list);
        list.add(ind[0], val);
        return list.get(list.size() - k);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */