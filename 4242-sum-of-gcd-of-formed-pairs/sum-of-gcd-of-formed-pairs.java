class Solution {
    public long gcdSum(int[] nums) {
        int max = 0;
        int n = nums.length;
        int ans[] = new int[n];

        for(int i = 0;i < n;i++){
            max = Math.max(max, nums[i]);
            ans[i] = gcd(nums[i], max);
        }

        Arrays.sort(ans);

        int l = 0, r = n-1;
        long sum = 0;
        while(l < r) sum += gcd(ans[l++], ans[r--]);
        

        return sum;
    }

    public int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}