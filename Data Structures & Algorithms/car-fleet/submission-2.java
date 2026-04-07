class Solution {
    class Pair{
        int pos; 
        int speed; 

        Pair(int pos, int speed){
            this.pos = pos; 
            this.speed = speed; 
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        List<Pair> pl = new ArrayList(); 

        for(int i=0; i<position.length;i++){
            Pair p = new Pair(position[i], speed[i]); 
            pl.add(p); 
        }

        Collections.sort(pl, (a, b) -> b.pos - a.pos);

        int fleetCount = 0; 
        double time = 0.0;

        for(int i=0; i<pl.size(); i++){
            Pair p = pl.get(i); 

            double currTime = (double)(target - p.pos) / p.speed;

            if(currTime > time){
                fleetCount++; 
                time = currTime; 
            }
        }

        return fleetCount; 
    }
}
