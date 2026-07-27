class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<List<Integer>> list = new ArrayList<>();
        int i = 1;
        int one = intervals[0][0];
        int two = intervals[0][1];

        while(i < n){
           if(two >= intervals[i][0]){
            one = Math.min(one, intervals[i][0]);
            two = Math.max(two, intervals[i][1]);
           }else {
            list.add(new ArrayList<>(Arrays.asList(one, two)));
            one = intervals[i][0];
            two = intervals[i][1];
           }
           i++;
        }
       
        list.add(new ArrayList<>(Arrays.asList(one, two)));
        int arr[][] = new int[list.size()][2];

        for(i = 0;i < list.size();i++){
            arr[i][0] = list.get(i).get(0);
            arr[i][1] = list.get(i).get(1);
        }

        return arr;

        
    }
}