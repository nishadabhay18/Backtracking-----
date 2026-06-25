class Solution {
    // TC-> O(m×n×4L) SC-> O(m×n+L)
    public boolean exist(char[][] board, String word) {
        int m=board.length, n=board[0].length;
        boolean[][] isVisited=new boolean[m][n];
        boolean result=false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(word.charAt(0)==board[i][j]){
                    result=backtrack(board, word, isVisited,i,j,0);
                    if(result==true) return true;
                }
            }
        }
        return false;
    }
    public boolean backtrack(char[][] board, String word, boolean[][] isVisited, int i, int j, int idx){
        int m=board.length, n=board[0].length;
        if(idx==word.length()) return true;
        if(i<0 || i>=m || j<0 || j>=n || isVisited[i][j]==true || board[i][j]!=word.charAt(idx)) return false;
        isVisited[i][j]=true;
        if(backtrack(board,word,isVisited,i+1,j,idx+1) || backtrack(board,word,isVisited,i-1,j,idx+1) || backtrack(board,word,isVisited,i,j+1,idx+1) || backtrack(board,word,isVisited,i,j-1,idx+1)){
            return true;
        }
        isVisited[i][j]=false;
        return false;
    }
}