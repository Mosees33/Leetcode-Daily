class Solution {
    public int compress(char[] chars) {
        int left = 0;
        int cnt = 1;
        char cur = chars[0];

        for(int i = 1;i < chars.length;i++){

            if(cur == chars[i]) cnt++;

            else {
                chars[left] = cur;
                left += 1;

                if(cnt > 1){
                    String temp = String.valueOf(cnt);
                    for(char c : temp.toCharArray()){
                        chars[left++] = c;
                    }
                }
                cur = chars[i];
                cnt = 1;
            }
        }

        chars[left] = cur;
        left += 1;
        if(cnt > 1){
            String temp = String.valueOf(cnt);
            for(char c : temp.toCharArray()){
                chars[left++] = c;
            }
        }
        
        return left;
    }
}