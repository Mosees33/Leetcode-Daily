class Solution {
    public int lengthOfLongestSubstring(String s) {
        int cnt = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int n = s.length();

        while(right < n){
            char c = s.charAt(right);
            if(!map.containsKey(c)){
                cnt = Math.max(cnt, right-left+1);
            }else {
                int temp = map.get(c)+1;
                for(;left < temp;left++) map.remove(s.charAt(left));
            }
            map.put(c, right);
            right++;
        }
        return cnt;
    }
}