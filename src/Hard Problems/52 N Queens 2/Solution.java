class Solution {
    // TC-> O(n! * n) SC-> O(n^2 + solutions * n^2)
    public int totalNQueens(int n) {
        char[][] chessBoard=new char[n][n];
        List<List<String>> result=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                chessBoard[i][j]='.';
            }
        }
        nQueen(chessBoard,0,result);
        return result.size();
    }
    public void nQueen(char[][] chessBoard, int row, List<List<String>> result){
        int n=chessBoard.length;
        if(row==n){
            List<String> answer=new ArrayList<>();
            for(int i=0;i<n;i++){
                String str="";
                for(int j=0;j<n;j++){
                    str+=chessBoard[i][j];
                }
                answer.add(str);
            }
            result.add(answer);
            return;
        }
        for(int j=0;j<n;j++){
            if(isSafe(chessBoard,row,j)){
                chessBoard[row][j]='Q';
                nQueen(chessBoard,row+1,result);
                chessBoard[row][j]='.';
            }
        }
    }
    public boolean isSafe(char[][] chessBoard, int row, int col){
        int n=chessBoard.length;
        for(int j=0;j<n;j++){
            if(chessBoard[row][j]=='Q') return false;
        }
        for(int i=0;i<n;i++){
            if(chessBoard[i][col]=='Q') return false;
        }
        int i=row, j=col;
        while(i>=0 && j<n){
            if(chessBoard[i][j]=='Q') return false;
            i--;
            j++;
        }
        i=row;
        j=col;
        while(i<n && j<n){
            if(chessBoard[i][j]=='Q') return false;
            i++;
            j++;
        }
        i=row;
        j=col;
        while(i<n && j>=0){
            if(chessBoard[i][j]=='Q') return false;
            i++;
            j--;
        }
        i=row;
        j=col;
        while(i>=0 && j>=0){
            if(chessBoard[i][j]=='Q') return false;
            i--;
            j--;
        }
        return true;
    }
}