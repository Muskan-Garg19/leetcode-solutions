class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int ans = 0;

        int leftFirst = 0;
        int rightFirst = firstLen - 1;
        int sumFirst = 0;

        // Initial first window
        for (int i = 0; i < firstLen; i++) {
            sumFirst += nums[i];
        }

        while (rightFirst < nums.length) {

            // -----------------------------
            // [FIRST][SECOND]
            // -----------------------------
            if (rightFirst + secondLen < nums.length) {

                int leftSec = rightFirst + 1;
                int rightSec = leftSec + secondLen - 1;

                int secSum = 0;

                for (int i = leftSec; i <= rightSec; i++) {
                    secSum += nums[i];
                }

                while (rightSec < nums.length) {

                    ans = Math.max(ans, sumFirst + secSum);

                    rightSec++;

                    if (rightSec < nums.length) {
                        secSum += nums[rightSec];
                        secSum -= nums[leftSec];
                        leftSec++;
                    }
                }
            }

            // -----------------------------
            // [SECOND][FIRST]
            // -----------------------------
            if (leftFirst >= secondLen) {

                int leftSec = 0;
                int rightSec = secondLen - 1;

                int secSum = 0;

                for (int i = 0; i < secondLen; i++) {
                    secSum += nums[i];
                }

                while (rightSec < leftFirst) {

                    ans = Math.max(ans, sumFirst + secSum);

                    rightSec++;

                    if (rightSec < leftFirst) {
                        secSum += nums[rightSec];
                        secSum -= nums[leftSec];
                        leftSec++;
                    }
                }
            }

            // Move first window
            rightFirst++;

            if (rightFirst < nums.length) {
                sumFirst -= nums[leftFirst];
                sumFirst += nums[rightFirst];
                leftFirst++;
            }
        }

        return ans;
    }
}