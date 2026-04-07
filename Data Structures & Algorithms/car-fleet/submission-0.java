class Solution {
    class Pair{
        int position; 
        int speed; 

        Pair(int position, int speed){
            this.position = position; 
            this.speed = speed; 
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        
        List<Pair> pl = new ArrayList(); 

        for(int i=0; i<position.length; i++){
            Pair p = new Pair(position[i], speed[i]); 
            pl.add(p);
        }

        Collections.sort(pl, (a, b)-> b.position - a.position);

        int fleetCount = 0; 
        double time = 0; 
        for(int i=0; i<pl.size(); i++){
            Pair p = pl.get(i); 

            double currTime = (double)(target - p.position) / p.speed;

            if(currTime > time){
                fleetCount++; 
                time = currTime; 
            }
        }

        return fleetCount; 
    }
}

/*
    (7,1), (4,2), (1,2), (0,1)
      3.     3.     5.     10

    currTime <= time 

    fleet++;
*/
