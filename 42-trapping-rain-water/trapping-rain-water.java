class Solution {
    public int trap(int[] height) {
        int leftMax = 0, rightMax = 0;
        int left = 0, right = height.length-1;
        int ans = 0;

        while(left < right){
            if(height[left] <= height[right]){
                if(leftMax < height[left]) leftMax = height[left];
                else ans += (leftMax - height[left]);
                left++;
            }else{
                if(rightMax <= height[right]) rightMax = height[right];
                else ans += (rightMax - height[right]);
                right--;
            }
        }
        return ans;
    }
}