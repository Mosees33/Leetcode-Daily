class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        int arr[] = new int[n1 + n2];

        for(int i = n1-1;i >= 0;i--){
            for(int j = n2-1;j >= 0;j--){
                int mul = (num1.charAt(i)-'0') * (num2.charAt(j) - '0');
                int p1 = i+j+1;
                int p2 = i+j;

                int sum = arr[p1] + mul;
                arr[p1] = sum % 10;
                arr[p2] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int v : arr){
            if(!(sb.length() == 0 && v == 0)) sb.append(v);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}