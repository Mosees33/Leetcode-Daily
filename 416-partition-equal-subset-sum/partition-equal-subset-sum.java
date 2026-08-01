class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums) sum += i;
        Arrays.sort(nums);

        int dp[][] = new int[nums.length][sum/2+1];
        for(int row[] : dp) Arrays.fill(row, -1);

        return sum % 2 == 0 ? f(nums.length-1, sum/2, nums, dp) : false;
    }

    public boolean f(int idx, int target, int nums[], int dp[][]){
        if(target == 0) return true;
        if(idx == 0){
            dp[idx][target] = target == nums[idx] ? 1 : 0;
            return target == nums[idx];
        }
        if(dp[idx][target] != -1) return dp[idx][target] == 1;

        boolean n_pick = f(idx-1, target, nums, dp);

        boolean pick = false;
        if(target >= nums[idx])
        pick = f(idx-1, target-nums[idx], nums, dp);

        dp[idx][target] = (pick || n_pick) ? 1 : 0;
        return pick || n_pick;
    }
}