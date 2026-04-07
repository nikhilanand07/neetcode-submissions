class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList(); 

        HashMap<String, List<String>> map = new HashMap(); 
        for(String s : strs){
            char[] cArr = s.toCharArray(); 
            char[] fp = new char[26];
            
            for(char c : cArr){
                fp[c-'a']++; 
            }

            String key = Arrays.toString(fp);

            map.computeIfAbsent(key, k -> new ArrayList()).add(s);
        }

        return new ArrayList(map.values()); 

    }
}
