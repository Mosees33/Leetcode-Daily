class Solution {
    public int[] searchRange(int[] nums, int target) {
        int arr[] = {-1, -1};
        
        int f = first(nums, target);
        if(f == -1) return arr;
        int s = second(nums, target);
        arr[0] = f;
        arr[1] = s;

        return arr;
    }

    public int first(int nums[], int x){
        int ans = -1;
        int l = 0,r = nums.length-1;

        while(l <= r){
            int mid = l + (r-l)/2;

            if(nums[mid] >= x){
                ans = nums[mid] == x ? mid : ans;
                r = mid-1;
            }
            else l = mid+1;
        }
        return ans;
    }

    public int second(int nums[], int x){
        int ans = -1;
        int l = 0,r = nums.length-1;

        while(l <= r){
            int mid = l + (r-l)/2;

            if(nums[mid] <= x){
                ans = nums[mid] == x ? mid : ans;
                l = mid+1;
            }
            else r = mid-1;
        }
        return ans;
    }
}