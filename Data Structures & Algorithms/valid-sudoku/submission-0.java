class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> row = new HashMap(); 
        Map<Integer, Set<Character>> col = new HashMap(); 
        Map<String, Set<Character>> squares = new HashMap(); 

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                Character num = board[i][j]; 
                String squareKey = i/3 + "," + j/3;
                if(board[i][j] =='.'){
                    continue; 
                }else if(row.computeIfAbsent(i, k -> new HashSet()).contains(num) || 
                col.computeIfAbsent(j, k -> new HashSet()).contains(num) || 
                squares.computeIfAbsent(squareKey, k-> new HashSet()).contains(num)){
                    return false; 
                }else{
                    row.get(i).add(num); 
                    col.get(j).add(num); 
                    squares.get(squareKey).add(num);
                }
            }
        }

        return true;
    }
}
