class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            String temp = sort(s);
            List<String> t;

            if(map.containsKey(temp)) t = map.get(temp);
            else t = new ArrayList<>();

            t.add(s);
            map.put(temp, t);
        }

        List<List<String>> list = new ArrayList<>();

        Iterator<List<String>> it = map.values().iterator();
        while(it.hasNext()){
            list.add(new ArrayList<>(it.next()));
        }

        return list;
    }

    public String sort(String s){
        char[] te = s.toCharArray();
        Arrays.sort(te);
        return new String(te);
    }
}