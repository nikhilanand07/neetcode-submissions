class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> map = new HashMap(); 

        for(String s : strs){
            char[] arr = new char[26]; 

            for(char c : s.toCharArray()){
                arr[c-'a']++; 
            }

            String ns = Arrays.toString(arr);
            map.putIfAbsent(ns, new ArrayList());
            map.get(ns).add(s);
        }


        List<List<String>> result = new ArrayList(); 
        for(List<String> list : map.values()){
            result.add(list);
        }

        return result; 
    }
}
