class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        f(0, target, candidates, list, ans);
        return ans;
    }

    public void f(int i, int target, int candidates[], List<Integer> list, List<List<Integer>> ans){
        if(i == candidates.length || target < 0) return;
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        f(i+1, target, candidates, list, ans);
        list.add(candidates[i]);
        f(i, target-candidates[i], candidates, list, ans);
        target += candidates[i];
        list.remove(list.size()-1);
        

    }
}