class Solution {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);

        int dp[][] = new int[coins.length][amount+1];
        for(int row[] : dp) Arrays.fill(row, -1);

        return f(coins.length-1, amount, coins, dp);
    }

    public int f(int n, int amount, int coins[], int dp[][]){
        if(n == 0){
            return dp[n][amount] = amount % coins[0] == 0 ? 1 : 0;
        }

        if(dp[n][amount] != -1) return dp[n][amount];

        int pick = 0;
        if(amount >= coins[n]) pick = f(n, amount-coins[n], coins, dp);
        int n_pick = f(n-1, amount, coins, dp);

        return dp[n][amount] = pick + n_pick;
    }
}