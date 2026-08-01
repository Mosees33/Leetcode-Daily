class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int  ans = 0, ps = 0;
        map.put(0, 1);
        int n = nums.length;

        for(int i = 0;i < n;i++){
            ps += nums[i];
            int temp = ps - k;
            if(map.containsKey(temp)) ans += map.get(temp);
            map.put(ps, map.getOrDefault(ps, 0)+1);
        }
        return ans;
    }
}