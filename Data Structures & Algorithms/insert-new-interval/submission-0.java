class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals, (a, b)-> a[0] - b[0]);

        int i = 0; 
        int n = intervals.length;

        List<int[]> res = new ArrayList(); 

        // add all intervals before overlap. 
        while(i<n && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]); 
            i++;
        }

        // merge overlap
        while(i<n && intervals[i][0] <= newInterval[1] ){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]); 
            i++; 
        }

        res.add(newInterval); 

        // all intervals after overlap
        while(i<n && intervals[i][0] > newInterval[1]){
            res.add(intervals[i]);
            i++; 
        }

        return res.toArray(new int[res.size()][]);
       
    }

    
}

/*
[2,5]

[1,3],[4,6]


out - [1,6]
*/
