class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int maxIdx = 0;
        int n = nums.length;
        for(int i = 0;i < n;i++){
            maxIdx = nums[maxIdx] < nums[i] ? i : maxIdx;
        }
        int k = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[maxIdx]);
        nums[maxIdx] = -1;

        for(int i = maxIdx-1;k < n;i--){
            int idx = (i+n) % n;
            int t = nums[idx];
            while(!stack.isEmpty() && stack.peek() <= t){
                stack.pop();
            }
            nums[idx] = !stack.isEmpty() ? stack.peek() : -1;
            stack.push(t);
            k++;
        }
        return nums;
    }
}