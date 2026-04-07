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
        List<Integer> startList = new ArrayList(); 
        List<Integer> endList = new ArrayList(); 

        for(Interval interval : intervals){
            startList.add(interval.start); 
            endList.add(interval.end);
        }

        Collections.sort(startList); 
        Collections.sort(endList);

        int startPtr = 0; 
        int endPtr = 0; 

        int maxDays = 0; 
        int days = 0; 
        while(startPtr < startList.size()){
            if(startList.get(startPtr) < endList.get(endPtr)){
                days++; 
                startPtr++; 
            }else{
                days--; 
                endPtr++; 
            }

            maxDays = Math.max(maxDays, days);
        }

        return maxDays; 
        
    }
}
