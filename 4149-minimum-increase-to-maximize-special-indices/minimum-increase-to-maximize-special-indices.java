class Solution {
    public long minIncrease(int[] nums) {
        int n= nums.length;
        long dp[][] = new long[n][2];
        for(long[] i : dp) Arrays.fill(i, -1);
        long arr[] = f(nums.length-2, nums, dp);
        return arr[1];
    }

    public static long[] f(int i, int nums[], long dp[][]){
        if(i == 1){
            int temp =Math.max(0, Math.max(nums[i-1], nums[i+1])+1 - nums[i]);
            return new long[]{1, temp};
        }
        if(i == 0){
            return new long[]{0, 0};
        }
        
        if(dp[i][0] != -1) return dp[i];

        long not_pick[] = f(i-1, nums, dp);
        
        int temp = Math.max(0, Math.max(nums[i-1], nums[i+1])+1 - nums[i]);
        long prevpick[] = f(i-2, nums, dp);
        long pick[] =new long[]{prevpick[0]+1, prevpick[1]+temp};

        if(pick[0] == not_pick[0]){
            dp[i] = pick[1] <= not_pick[1] ? pick : not_pick;
        } else {
            dp[i] = pick[0] > not_pick[0] ? pick : not_pick; 
        }
        return dp[i];
    }
}