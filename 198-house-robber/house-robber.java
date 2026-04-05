class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        dp[0] = nums[0];

        for(int i = 1;i < n;i++){
            int pick = nums[i] + (i > 1 ? dp[i-2] : 0);
            int notpick = dp[i-1];

            dp[i] = Math.max(pick, notpick);
        }
        return dp[n-1];
    }
}