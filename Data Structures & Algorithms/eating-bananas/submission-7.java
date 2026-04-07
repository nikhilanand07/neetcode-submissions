class Solution {
    int minH = Integer.MAX_VALUE;
    public int minEatingSpeed(int[] piles, int h) {
        
        int l=0; 
        int r =0; 

        for(int i=0; i<piles.length; i++){
            r = Math.max(r, piles[i]);
        }

        while(l <= r){
            int mid = (l+r)/2; 
            System.out.println(mid);

            if(canEat(mid, piles, h)){
                System.out.println("Min H is "+minH+" and mid is : "+mid);
                if(mid < minH){
                    minH = mid; 
                    
                } 
                r = mid-1; 
            }else {
                l= mid+1; 
            }
        }

        return minH; 
    }

    private boolean canEat(int h, int[] piles, int target){
        long time = 0; 

        for(int i=0; i<piles.length; i++){
            time += Math.ceil((double)piles[i]/h);
        }

        return time <= target; 
    }
}
