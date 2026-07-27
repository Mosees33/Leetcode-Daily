class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        
        for(int i = 0;i < s.length();i++){
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);
            
            if(map1.containsKey(s1) && map1.get(s1) != t1 || map2.containsKey(t1) && map2.get(t1) != s1) return false;
            
            map1.put(s1, t1);
            map2.put(t1, s1);
        }
        return true;
    }
}