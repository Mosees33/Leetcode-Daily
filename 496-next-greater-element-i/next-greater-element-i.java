class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = nums2.length-1;i >= 0;i--){
            int temp = nums2[i];
            while(!stack.isEmpty()){
                if(stack.peek() < temp) stack.pop();
                else break;
            }

           map.put(temp, !stack.isEmpty() ? stack.peek() : -1);
           stack.push(temp);
        }

        for(int i = 0;i < nums1.length;i++){
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }
}