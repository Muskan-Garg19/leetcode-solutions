class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0 || nums.length==1){
            return nums.length;
        }
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }

        int max=Integer.MIN_VALUE;
        for(int curr:set){
            int count=1;
            if(set.contains(curr-1)){
                continue;
            }
            while(set.contains(curr+1)){
                count++;
                curr=curr+1;
            }
            max=Math.max(max,count);
        }
        return max;
    }
}