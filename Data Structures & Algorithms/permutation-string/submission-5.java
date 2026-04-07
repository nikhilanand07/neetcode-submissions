class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length())
            return false; 
    

        char[] s1Arr = new char[26]; 
        char[] s2Arr = new char[26];

    

        // first populate s1Arr 
        for(int i=0; i<s1.length(); i++){
            s1Arr[s1.charAt(i) - 'a'] ++;  
        }

        // first window 

        for(int i=0; i<s1.length(); i++){
            s2Arr[s2.charAt(i) - 'a']++; 
        }

        int windowSize = s1.length(); 

        int left = 0; 

        for(int i=windowSize; i<s2.length(); i++){
            if(matches(s1Arr, s2Arr)){
                return true; 
            }

            // increase window size by 1 and decrease by 1
            s2Arr[s2.charAt(i) - 'a']++; 
            s2Arr[s2.charAt(i-windowSize) -'a'] --; 
        }

        return matches(s1Arr, s2Arr);
        
    }

    public boolean matches(char[] s1, char[] s2){
        for(int i=0; i<s1.length; i++){
            if(s1[i] != s2[i])
                return false; 
        }

        return true; 
    }
}
