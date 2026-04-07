class Solution {
    public int characterReplacement(String s, int k) {
        // count 
        Map<Character, Integer> map = new HashMap(); 

        int res = 0;
        int maxf = 0; 

        int l =0; 

        for(int r = 0; r<s.length(); r++){
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1); 
            
            maxf = Math.max(maxf, map.get(c)); 

            while((r-l+1) - maxf > k){
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) - 1);
                l++; 
            }

            res = Math.max(r-l+1, res);
        }

        return res; 
        
    }
}
