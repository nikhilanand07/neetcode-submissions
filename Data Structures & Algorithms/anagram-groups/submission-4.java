class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>(); 

        for(String s : strs){
            char[] c = s.toCharArray(); 

            int[] arr = new int[26];
            for(int i=0; i<c.length; i++){
                arr[c[i] - 'a']++; 
            }

            String ns = Arrays.toString(arr); 
            map.putIfAbsent(ns, new ArrayList()); 
            map.get(ns).add(s);
        }


        List<List<String>> result = new ArrayList(); 

        for(List<String> r : map.values()){
            result.add(r);
        }

        return result; 

    }
}

/*

arr[26] - 

hashmap - (hashedString, List<actualString>) 

// TC - n*m
// SC - n

*/

