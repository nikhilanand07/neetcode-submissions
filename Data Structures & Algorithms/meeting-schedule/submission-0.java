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

        // sort on the basis of start time
        Collections.sort(intervals, (a, b) -> a.start - b.start); 

        for(int i=0; i<intervals.size()-1; i++){

            int startTime = intervals.get(i+1).start; 
            int endTime = intervals.get(i).end; 

            if(startTime < endTime){
                return false; 
            }
        }

        return true; 
    }
}
