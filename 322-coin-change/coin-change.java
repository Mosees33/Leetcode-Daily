class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount+1];
        Arrays.sort(coins);
        for(int row[] : dp) Arrays.fill(row, -1);
        int temp = f(coins.length-1, amount, coins, dp);
        return temp == Integer.MAX_VALUE ? -1 : temp;
    }
    public int f(int n, int target, int coins[], int dp[][]){
        if(n == 0) return target % coins[n] == 0 ? target/coins[n] : Integer.MAX_VALUE;
        if(dp[n][target] != -1) return dp[n][target]; 
        

        int take = Integer.MAX_VALUE;
        if(target >= coins[n]){
            int temp = f(n, target-coins[n], coins, dp);
            take = temp != Integer.MAX_VALUE ? 1 + temp : Integer.MAX_VALUE;
        }
        int n_take = f(n-1, target, coins, dp);

        return dp[n][target] = Math.min(take, n_take);
    }
}