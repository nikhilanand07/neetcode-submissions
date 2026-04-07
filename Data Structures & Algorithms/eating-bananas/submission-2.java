class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1; 
        int right = 0;

        // Find maximum pile
        for(int p : piles){
            right = Math.max(right, p);
        }

        while(left <= right){

            int mid = left + (right - left) / 2;

            if(canEat(piles, h, mid)){
                right = mid - 1;  // try smaller speed
            }else{
                left = mid + 1;   // need higher speed
            }
        }

        return left;
    }

    private boolean canEat(int[] piles, int h, int speed){

        int totalHours = 0;

        for(int p : piles){

            // Equivalent to ceil(p / speed)
            totalHours += (int)Math.ceil((double)p/speed);
        }

        return totalHours <= h;
    }
}