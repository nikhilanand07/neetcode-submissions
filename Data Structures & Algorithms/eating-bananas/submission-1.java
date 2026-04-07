class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lm = 1; 
        int rm = 0; 

        for(int p : piles){
            rm = Math.max(rm, p);
        }

        while(lm <= rm){
            int mid = (lm + rm) / 2; 

            if(canEat(piles, h, mid)){
                rm = mid-1; 
            }else {
                lm = mid+1;
            }
        }

        return lm; 
    }

    private boolean canEat(int[] piles, int h, int speed){

    int totalHours = 0;

    for(int p : piles){
        totalHours += (int)Math.ceil((double)p / speed);
    }

    return totalHours <= h;
}
}
