class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0 || intervals.length == 1)
            return intervals;
        
        Arrays.sort(intervals,(a,b) -> {
            if(a[0] == b[0])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        List<int[]> newIntervals = new ArrayList<>();
        int prev0 = intervals[0][0];
        int prev1 = intervals[0][1];
        
        //1,6 2,5
        for(int i = 1; i < intervals.length; ++i){
            int curr0 = intervals[i][0];
            int curr1 = intervals[i][1];
            if(curr0 <= prev1){
                prev0 = Math.min(prev0, curr0);
                prev1 = Math.max(prev1, curr1);
            } else {
                newIntervals.add(new int[] {prev0,prev1});
                prev0 = curr0;
                prev1 = curr1;
            }
            if(i == intervals.length-1)
                newIntervals.add(new int[] {prev0,prev1});
        }
        return newIntervals.toArray(new int[newIntervals.size()][]);
    }
}
