class Solution {
    String encodedStr; 
    List<String> result; 
    List<Integer> lenArr; 
    public String encode(List<String> strs) {
        encodedStr = "";
        lenArr = new ArrayList();
        for(String str : strs){
            encodedStr += str;

            lenArr.add(str.length());
        }

        return encodedStr;  
    }

    public List<String> decode(String str) {

        result = new ArrayList(); 

        int start = 0; 
        int end = 0; 
        for(int l : lenArr){
            end += l; 
            result.add(str.substring(start, end));

            start = end; 
        }

        return result; 
    }
}
