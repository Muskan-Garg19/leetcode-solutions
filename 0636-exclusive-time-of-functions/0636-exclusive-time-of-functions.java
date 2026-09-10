
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] free = new int[n];

        int[] stack = new int[logs.size()];
        int top = -1;

        int currTime = 0;

        for (String str : logs) {
            String[] log = str.split(":");

            int ind = Integer.parseInt(log[0]);
            int time = Integer.parseInt(log[2]);

            if (log[1].equals("start")) {

                // Previous function was running until this function started
                if (top >= 0) {
                    free[stack[top]] += time - currTime;
                }

                // Add current function
                stack[++top] = ind;

                currTime = time;

            } else {

                // Current function runs through the end timestamp
                free[stack[top]] += time - currTime + 1;

                // Remove current function
                top--;

                currTime = time + 1;
            }
        }

        return free;
    }
}

