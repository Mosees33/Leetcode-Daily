class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        f(0, nums, list);
        return list;
    }

    public void f(int i, int nums[], List<List<Integer>> list){
        if(i == nums.length){
            List<Integer> l = new ArrayList<>();
            for(int k : nums) l.add(k);
            list.add(new ArrayList<>(l));
            return;
        }

        for(int j = i;j < nums.length;j++){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            f(i+1, nums, list);
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}