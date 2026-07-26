class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s : strs){

            String temp = sort(s);
            if(!map.containsKey(temp)) map.put(temp, new ArrayList<>());
            map.get(temp).add(s);
            
        }

        return new ArrayList<>(map.values());
    }

    public String sort(String s){
        char[] te = s.toCharArray();
        Arrays.sort(te);
        return new String(te);
    }
}