class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, boolean[]> map = new HashMap<>();
        for(int i=0; i<reservedSeats.length; i++) {
            int row = reservedSeats[i][0];
            int col = reservedSeats[i][1];
            boolean[] arr = new boolean[11];
            if(map.containsKey(row)) {
                arr = map.get(row);
            }
            arr[col] = true;
            map.put(row, arr);
        }
        int ans = (n - map.size()) * 2;
        for(boolean[] arr  : map.values()) {
            if(!arr[2] && !arr[3] && !arr[4] && !arr[5]) {
                ans++;
                if(!arr[6] && !arr[7] && !arr[8] && !arr[9]) {
                    ans++;
                }
            }
            else if(!arr[4] && !arr[5] && !arr[6] && !arr[7]) {
                ans++;
            }
            else if(!arr[6] && !arr[7] && !arr[8] && !arr[9]) {
                ans++;
            }
        }

        return ans;
    }
}