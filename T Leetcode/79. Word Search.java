class Solution {
    private char[][] board;
    private int ROWS;
    private int COLS;
    
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;
        
        for (int row = 0; row < this.ROWS; row++) 
            for (int col = 0; col < this.COLS; col++) 
                if (this.backtrack(row, col, word, 0)) 
                    return true;
                
                return false;
            
        
    }
    protected boolean backtrack(int row, int col, String word, int index) {
        //Step1: check the bottom case
        if (index >= word.length()) {
            return true;
        }
        //Step2:check the boundaries
        if (row < 0 || row == this.ROWS || col < 0 || col == this.COLS ||
           this.board[row][col] != word.charAt(index)) 
            return false;
            //Step3:explore the neighbours in DFS
            boolean ret = false;
            //mark the path before the next exploration
            this.board[row][col] = '#';
            
            int[] rowOffsets = {0,1,0,-1};
            int[] colOffsets = {1,0,-1,0};
            for (int d = 0; d < 4; d++) {
                ret = this.backtrack(row + rowOffsets[d], col + colOffsets[d], word, index + 1);
                if (ret) 
                    break;
                }
                //Step4: clean up and return the result
            this.board[row][col] = word.charAt(index);
            return ret;
               
    }
}

class Solution {
    private int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for(int i = 0; i<rows; i++ ){
            for(int j = 0; j<cols; j++ ){
                if (dfs(board, visited, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, boolean[][] visited, String word, int x, int y, int idx){
        if (idx == word.length()) return true;
        if (x<0 || x>=board.length||y<0|| y>=board[0].length ||visited[x][y] || board[x][y]!=word.charAt(idx)){
            return false;
        }
        
        visited[x][y] = true;
        boolean result = false;
        for (int[] dir : directions){
            if (dfs(board, visited, word, x+dir[0], y+dir[1], idx+1)){
                result = true;
                break;
            }
        }
        visited[x][y] = false;
        return result;
    }
}