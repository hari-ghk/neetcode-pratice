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
    public int minMeetingRooms(List<Interval> intervals) {
        
        if(intervals == null || intervals.isEmpty())
            return 0;

        Collections.sort(intervals, (i1,i2) -> i1.start - i2.start);

        PriorityQueue<Interval> pq = new PriorityQueue<>((i1, i2) -> i1.end - i2.end);
        pq.add(intervals.get(0));

        for(int i = 1; i < intervals.size(); ++i){
            if(intervals.get(i).start >= pq.peek().end){
                pq.poll();
            }
            pq.add(intervals.get(i));
        }
        return pq.size();
    }
}
