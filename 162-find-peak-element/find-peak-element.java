class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0,r = n-1;
        while(l <= r){
            int mid = l + (r-l) / 2;
            if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == n-1 || nums[mid] > nums[mid+1])) return mid;

            if(mid != 0 && nums[mid-1] > nums[mid]) r = mid-1;

            else if(mid != n-1 && nums[mid+1] > nums[mid]) l = mid+1;
        }
        return -1;
    }
}