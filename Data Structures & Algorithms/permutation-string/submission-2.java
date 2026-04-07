class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        char[] s1Array = s1.toCharArray(); 
        Arrays.sort(s1Array);
        String sortedS1 = new String(s1Array);

        int l=0;
        for(int r=0; r<s2.length(); r++){
            while((r-l+1) < s1.length() && r<s2.length()-1){
                r++;
            }

            char[] sub = s2.substring(l, r+1).toCharArray();
            Arrays.sort(sub);
            String sortedSub = new String(sub); 

            if(sortedSub.equals(sortedS1)){
                return true; 
            }

            l++;
        } 

        return false; 
    }
}
