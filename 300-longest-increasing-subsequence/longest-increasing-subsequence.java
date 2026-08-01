class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for(int i = 1;i < n;i++){
            if(nums[i] > list.get(list.size()-1)) list.add(nums[i]);
            else {
                int idx = f(nums[i], list);
                list.set(idx, nums[i]);
            }
        }
        return list.size();
    }
    public int f(int val, List<Integer> list){
        int l = 0, r = list.size()-1;
        while(l <= r){
            int mid = (l+r) / 2;
            if(list.get(mid) == val) return mid;
            else if(list.get(mid) > val) r = mid-1; 
            else l = mid+1;
        }
        return l;
    }
}