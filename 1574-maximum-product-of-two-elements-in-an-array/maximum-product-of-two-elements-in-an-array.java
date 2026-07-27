class Solution {
    public int maxProduct(int[] nums) {
        int one = 1, two = 1;

        for(int i : nums){
            if(one <= i){
                two = one;
                one = i;
            }else if(two <= i) two = i;
        }

        return (one-1) * (two-1);
    }
}