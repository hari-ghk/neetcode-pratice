/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {

        if(intervals == null || intervals.size() == 0 || intervals.size()==1)
            return true;
        
        intervals.sort(Comparator.comparing((Interval i) -> i.start).thenComparing(i -> i.end));
        Interval prevInterval = intervals.get(0);
        for(int i = 1; i < intervals.size(); ++i){
            if(intervals.get(i).start < prevInterval.end){
                return false;
            }
            prevInterval = intervals.get(i);
        }
        return true;
    }
}
