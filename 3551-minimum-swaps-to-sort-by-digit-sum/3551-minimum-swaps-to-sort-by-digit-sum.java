class Solution {

    class Pair {
        int digitSum;
        int number;
        Pair (int digitSum, int number) {
            this.digitSum = digitSum;
            this.number = number;
        }
    }

    class MyComparator implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            if(a.digitSum != b.digitSum) {
                return Integer.compare(a.digitSum, b.digitSum);
            }
            return Integer.compare(a.number, b.number);
        }
    }

    static int digitSum(int n) {
        int sum = 0;
        while(n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        Pair[] pair = new Pair[n];

        for(int i = 0; i < n; i++) {
            map.put(nums[i], i);
            pair[i] = new Pair(digitSum(nums[i]), nums[i]);
        }
        
        Arrays.sort(pair, new MyComparator());

        int ans = 0;
        for(int i = 0; i < n; i++) {
            int target = pair[i].number;
            if (nums[i] != target) {
                ans++;

                int j = map.get(target);
                int current = nums[i];

                nums[i] = target;
                nums[j] = current;

                map.put(target, i);
                map.put(current, j);
            }
        }
        
        return ans;
    }
}