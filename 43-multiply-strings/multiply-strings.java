class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < n1+n2;i++) sb.append('0');

        for(int i = n1-1;i >= 0;i--){
            for(int j = n2-1;j >= 0;j--){
                int c1 = num1.charAt(i) - '0';
                int c2 = num2.charAt(j) - '0';

                int prod = c1 * c2;
                int rem = prod % 10;
                int c = prod / 10;

                helper(sb, rem, i+j+1);
                helper(sb, c, i+j);
            }
        }
        while(sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);

        return sb.toString();
    }

    public void helper(StringBuilder sb, int val, int pos){
      
        int sum = sb.charAt(pos)-'0' + val;
        sb.setCharAt(pos, (char)(sum%10 + '0'));
        if(sum > 9){
            helper(sb, sum / 10, pos-1);
        }
    }
}