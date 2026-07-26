class Solution {
    public int lengthOfLongestSubstring(String s) {
        int cnt = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int n = s.length();

        while(right < n){
            char c = s.charAt(right);
            if(map.containsKey(c)) left = Math.max(left, map.get(c)+1);
            map.put(c, right);
            cnt = Math.max(cnt, (right-left+1));
            right++;
        }
        return cnt;
    }
}