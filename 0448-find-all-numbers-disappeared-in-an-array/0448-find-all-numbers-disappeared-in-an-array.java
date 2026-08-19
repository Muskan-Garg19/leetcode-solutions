class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        boolean helper[] = new boolean[n+1];
        for(int i=0; i<n; i++) {
            helper[nums[i]] = true;
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<n+1; i++) {
            if(!helper[i]) {
                list.add(i);
            }
        }

        return list;
    }
}