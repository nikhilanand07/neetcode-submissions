class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.length() > s2.length()){
            return false; 
        }

        char[] s1Array = new char[26];
        char[] s2Array = new char[26];

        for(int i = 0; i<s1.length(); i++){
            s1Array[s1.charAt(i) - 'a']++;
        }

        int windowSize = s1.length(); 

        // first window
        for(int i=0; i<windowSize; i++){
            s2Array[s2.charAt(i)- 'a']++;
        }

        for(int i=windowSize; i<s2.length(); i++){

            if(matches(s1Array, s2Array)){
                return true;
            }

            // add one char 
            s2Array[s2.charAt(i) - 'a']++; 

            // remove one char 
            s2Array[s2.charAt(i-windowSize) - 'a']--;

        }
        return matches(s1Array, s2Array); 
    }

    public boolean matches(char[] s1Array, char[] s2Array){
        for(int i=0; i<s1Array.length; i++){
            if(s1Array[i] != s2Array[i]){
                return false;
            }
        }
        return true; 
    }
}

// TC - O(nlogm) - n is the size of the original string
// SC - O(m) - where m is time size of the substring.
