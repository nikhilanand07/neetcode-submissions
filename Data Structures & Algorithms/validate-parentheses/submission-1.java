class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>(); 

        char[] chArray = s.toCharArray(); 

        for(Character ch : chArray){
            if(ch.equals('[') || ch.equals('(') || ch.equals('{')){
                stack.push(ch);
            }else if(!stack.isEmpty()){

                Character ch1 = stack.pop(); 

                if(
                    (ch.equals(')') && !ch1.equals('('))  || 
                    (ch.equals(']') && !ch1.equals('['))   || 
                    (ch.equals('}') && !ch1.equals('{'))
                ){
                    return false; 
                }
            }else{
                return false; 
            }
        }

        if(!stack.isEmpty()){
            return false; 
        }

        return true; 
    }
}
