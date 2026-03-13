class Solution {
    public int longestPalindrome(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int len = 0;

        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        boolean odd = false;
        for(Integer val : map.values()){
            if(val % 2 == 0) len += val;
            else{
                len += (val-1);
                odd = true;
            }
        }
        return odd ? len+1 : len;
    }
}