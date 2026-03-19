class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> list = new ArrayList<>();
        int col = rowIndex + 1;

        long res = 1;
        list.add((int) res);

        for(int i  = 1;i < col;i++){
            res *= (col-i);
            res /= i;
            list.add((int) res);
        }
        return list;
    }
}