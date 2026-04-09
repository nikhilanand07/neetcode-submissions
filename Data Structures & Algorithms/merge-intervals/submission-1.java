class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); 

        List<int[]> res = new ArrayList(); 

        res.add(new int[]{intervals[0][0], intervals[0][1]}); 

        for(int i=1; i<intervals.length; i++){
          int[] lastAdded = res.get(res.size()-1); 
          if(intervals[i][0] <= lastAdded[1]){
            lastAdded[1] = Math.max(intervals[i][1], lastAdded[1]); 
          }else{
            res.add(intervals[i]);
          }
        }

      return res.toArray(new int[res.size()][]);
        
    }
}
