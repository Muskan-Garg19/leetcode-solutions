class Solution {

    public int minimumPushes(String word) {
        int[] arr = new int[26];
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            int index = ch-'a';
            arr[index]++;
        }

        //sorting in descending order;
        for(int i = 0; i< 26; i++) {
            for(int j = 0; j < 26 - i - 1; j++) {
                if(arr[j] < arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        int ans = 0;
        int i = 0;
        int n = 1;

        while(i< arr.length && arr[i] > 0) {
            int j = 1;
            while(i< arr.length && arr[i] > 0 && j<= 8) {
                int free = arr[i];
                ans += (free * n);
                i++;
                j++;
            }
            n++;
        }

        return ans;
    }
}