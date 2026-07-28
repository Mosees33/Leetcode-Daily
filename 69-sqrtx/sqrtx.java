class Solution {
    public int mySqrt(int x) {
        if(x <= 1) return x;
        if(x <= 3) return 1;
        int l = 0;
        int r = x/2;
        long ans = 0;

        while(l <= r){
            int mid = l + (r-l)/2;
            
            if((long)mid*mid == x) return mid;
            
            else if((long)mid*mid < x){
                ans = mid;
                l = mid+1;
            }
            
            else r = mid-1;
        }

        return (int)ans;
    }
}