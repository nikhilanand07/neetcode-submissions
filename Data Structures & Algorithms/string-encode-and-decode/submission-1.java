class Solution {

    private List<Integer> cArr;
    

    public String encode(List<String> strs) {
        cArr = new ArrayList(); 
        String encodedStr = "";
        for(String str : strs){
            cArr.add(str.length()); 
            encodedStr += str; 
        }

        System.out.println(encodedStr);
        System.out.println(cArr.size());
        return encodedStr; 
    }

    public List<String> decode(String str) {
        
        List<String> decodedStr = new ArrayList(); 
        int start = 0;
        int end = 0;
        for(int i=0; i<cArr.size(); i++){
            
            if(i==0){
                end += cArr.get(i);
                String s = str.substring(start, end);
                decodedStr.add(s);
            }else{
                start += cArr.get(i-1);
                end += cArr.get(i);
                String s = str.substring(start, end);
                decodedStr.add(s);
            }
        }

        return decodedStr; 
    }
}
