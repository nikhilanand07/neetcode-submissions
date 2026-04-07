class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet(); 

        for(int n : nums){
            set.add(n); 
        }

        int longest = 0; 

        for(int n : nums){
            int length = 0; 

            if(!set.contains(n-1)){
                while(set.contains(n+length)){
                    length++; 
                }

                longest = Math.max(length, longest); 
            }
        }

        return longest; 

    }
}
