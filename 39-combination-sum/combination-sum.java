class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        f(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    public void f(int i, int nums[], int target, List<List<Integer>> ans, List<Integer> list){
        if(i == nums.length){
            if(target == 0) ans.add(new ArrayList<>(list));
            return;
        }

        if(nums[i] <= target){
            list.add(nums[i]);
            f(i, nums, target-nums[i], ans, list);
            list.remove(list.size()-1);
        }
        f(i+1, nums, target, ans, list);
    }
}