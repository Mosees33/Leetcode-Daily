class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[1], nums[0]);

        int a = nums[0], b = nums[1], c = nums[2]+a;
        int d = 0;
        for(int i = 3;i < nums.length;i++){
            d = nums[i] + Math.max(a, b);
            a = b;
            b = c;
            c = d;
        }
        return Math.max(b, c);
    }
}