class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a,b)-> a[0] - b[0]);

        int[][] q = new int[queries.length][2];

        int res[] = new int[queries.length];
        Arrays.fill(res, -1);

        for(int i=0; i<queries.length; i++){
          q[i][0] = queries[i];
          q[i][1] = i; 
        }

        Arrays.sort(q, (a,b) -> Integer.compare(a[0], b[0])); 

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0], b[0])); // {size, end}

        // process the query
        int i=0;
        int n = intervals.length;
        for(int[] qr : q){
          int query = qr[0]; 
          int idx = qr[1];

          

          // add all the intervals whose start is less than equal to query
          while(i<n && intervals[i][0] <= query){
            int start = intervals[i][0]; 
            int end = intervals[i][1]; 

            int size = end - start + 1; 

              pq.offer(new int[]{size, end});

              i++;

          }

          // reomve all the intervals whose end is less than query

          while(!pq.isEmpty() && query > pq.peek()[1]){
              pq.poll(); 
          }
          if(!pq.isEmpty())
            res[idx] = pq.peek()[0]; 
        }

        return res; 
    }
}
