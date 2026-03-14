class Solution {
    public String addStrings(String num1, String num2) {
        if(num1.length() < num2.length()){
            String t = num1;
            num1 = num2;
            num2 = t;
        }

        int s1 = num1.length()-1;
        int s2 = num2.length()-1;
        int carry = 0;
        String ans = "";

        while(s2 >= 0){
            char c1 = num1.charAt(s1);
            char c2 = num2.charAt(s2);

            int temp1 = (c1 - '0') + (c2 - '0') + carry;
            int temp2 = temp1 % 10; 

            ans = String.valueOf(temp2) + ans;
            carry = temp1 / 10;
            s1--;
            s2--;
        }
        if(carry == 0) return num1.substring(0, s1+1) + ans;

        while(s1 >= 0){
            if(carry > 0){
                int c = num1.charAt(s1) - '0';
                int t1 = (c + carry) % 10;
                ans = String.valueOf(t1) + ans;
                carry = (c + carry) / 10;
            }
            else{
                ans = num1.substring(0, s1+1) + ans;
                return carry == 0 ? ans : "1" + ans;
            } 
            s1--;
        }
        return carry == 0 ? ans : "1" + ans;
    }
}