class Solution {
    public long minIncrease(int[] nums) {
        int n = nums.length;

        long[] prev2 = {0, 0};
        int t = Math.max(0, Math.max(nums[0], nums[2])+1 - nums[1]);
        long[] prev1 = {1, t};

        for(int i = 2;i < n-1;i++){
            long curr[] = new long[2];
            int temp = Math.max(0, Math.max(nums[i-1], nums[i+1])+1 - nums[i]);

            if(prev2[0]+1 == prev1[0]){
                curr[0] = prev1[0];
                curr[1] = Math.min(prev2[1]+temp, prev1[1]);
            } else if(prev2[0]+1 > prev1[0]){
                curr[0] = prev2[0]+1;
                curr[1] = prev2[1] + temp;
            } else {
                curr = prev1;
            }

            prev2 = prev1;
            prev1 = curr;
        }
        return prev1[1];
    }
}