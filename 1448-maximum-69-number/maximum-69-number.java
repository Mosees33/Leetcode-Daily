class Solution {
    public int maximum69Number (int num) {
        String temp = String.valueOf(num);
        temp = temp.replaceFirst("6", "9");
        return Integer.valueOf(temp);
    }
}