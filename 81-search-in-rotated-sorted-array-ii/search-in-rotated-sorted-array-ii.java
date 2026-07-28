class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0,r = nums.length-1;

        while(l <= r){
            int mid = l + (r-l) / 2;
            if(nums[mid] == target) return true;

            else if(nums[mid] > nums[l]){
                if(nums[l] <= target && nums[mid] > target) r = mid-1;
                else l = mid+1;
            }

            else if(nums[r] > nums[mid]){
                if(nums[mid] < target && nums[r] >= target) l = mid+1;
                else r = mid-1;
            }

            else if(nums[l] == nums[mid]) l=l+1;
            else r = r-1;
        }
        return false;
    }
}