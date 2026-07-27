class Solution {
    public int maxProduct(int[] nums) {
        int one = 0, two = -1;
        if(nums[0] > nums[1]){
            one = 0;
            two = 1;
        }else{
            one = 1;
            two = 0;
        }
        
        for(int i = 2;i < nums.length;i++){
            if(nums[one] < nums[i]){
                two = one;
                one = i;
            }else if(i != one && nums[two] < nums[i]) {
                two = i;
            }
        }

        return (nums[one]-1) * (nums[two]-1);
    }
}