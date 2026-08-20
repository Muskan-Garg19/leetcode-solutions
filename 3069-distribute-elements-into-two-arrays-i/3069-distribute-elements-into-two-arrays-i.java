class Solution {
    public int[] resultArray(int[] nums) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list1.add(nums[0]);
        list2.add(nums[1]);
        for(int i=2; i<nums.length; i++) {
            if(list1.get(list1.size()-1) > list2.get(list2.size()-1)) {
                list1.add(nums[i]);
            }
            else {
                list2.add(nums[i]);
            }
        }

        int[] ans = new int[nums.length];
        for(int i=0; i<list1.size(); i++) {
            ans[i] = list1.get(i);
        }
        int j = list1.size();
        for(int i=0; i<list2.size(); i++) {
            ans[j] = list2.get(i);
            j++;
        }

        return ans;
    }
}