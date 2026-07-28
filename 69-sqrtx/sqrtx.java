class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        if(x <= 3) return 1;
        long i = 2;
        while(i < x){
            if(i*i == (long)x) return (int)i;
            if(i*i > (long)x) break;
            i++;
        }
        return (int)i-1;
    }
}