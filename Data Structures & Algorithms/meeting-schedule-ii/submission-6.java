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
        // sort intervals based on their start time
        Collections.sort(intervals, (a,b) -> a.start - b.start);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Interval interval : intervals){
            if(!pq.isEmpty() && pq.peek() <= interval.start){
                pq.poll();
            }
            pq.add(interval.end);
        }

        return pq.size();
    }
}
