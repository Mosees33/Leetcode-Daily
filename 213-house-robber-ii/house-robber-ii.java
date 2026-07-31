class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        if(n == 3) return Math.max(nums[0], Math.max(nums[1], nums[2]));

        return Math.max(f(0, n-2, nums), f(1, n-1, nums));
    }
    public int f(int l, int r, int nums[]){
        int a = nums[l], b = nums[l+1], c = nums[l+2]+a;
        int d = 0;
        for(int i = l+3;i <= r;i++){
            d = nums[i] + Math.max(a, b);
            a = b;
            b = c;
            c = d;
        }
        return Math.max(b, c);
    }
}