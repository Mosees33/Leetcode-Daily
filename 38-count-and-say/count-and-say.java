class Solution {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        return count(n, sb);
    }

    public String count(int n, StringBuilder sb){
        if(n == 1) return sb.toString();

        int num = sb.charAt(0);
        int cnt = 1;
        StringBuilder temp = new StringBuilder();
        
        for(int i = 1;i < sb.length();i++){
            if(num == sb.charAt(i)) cnt++;
            else{
                temp.append(cnt);
                temp.append(num - '0');
                num = sb.charAt(i);
                cnt = 1;
            }
        }
        temp.append(cnt);
        temp.append(num - '0');

        return count(n-1, temp);
    }
}