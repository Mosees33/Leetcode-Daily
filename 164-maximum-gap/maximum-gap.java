class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length < 2) return 0;
        int maxgap = 0, min = Integer.MAX_VALUE, max = -1;

        for(int i : nums){
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        int n = nums.length-1;
        
        int bucketsize = (int)Math.ceil((double)(max - min) / n);

        int minval[] = new int[n];
        int maxval[] = new int[n];

        Arrays.fill(minval, max);
        Arrays.fill(maxval, -1);

        for(int i = 0;i < n+1;i++){
            if(nums[i] == min || nums[i] == max) continue;

            int temp = (nums[i] - min) / bucketsize;

            minval[temp] = Math.min(minval[temp], nums[i]);
            maxval[temp] = Math.max(maxval[temp], nums[i]);
        }

        for(int i = 0;i < n;i++){
            if(minval[i] == max) continue;
            
            maxgap = Math.max(minval[i] - min, maxgap);
            min = maxval[i];
        }

        return Math.max(maxgap, max-min);
    }
}