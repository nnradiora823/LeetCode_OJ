package word_search;

/*
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 */

public class Solution {
	public boolean exist(char[][] board, String word) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(board==null || board.length==0){
            if(word==null || word.length()==0)
                return false;
            return true;
        }
        
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(board[i][j]==word.charAt(0)){
                    board[i][j] = '#';
                    if(existHelper(board, word, i, j, 1)){
                        return true;
                    }
                    board[i][j] = word.charAt(0);
                }
            }
        }
        return false;
    }
    
    public boolean existHelper(char[][] board, String word, int row, int col, int index){
        if(index==word.length())
            return true;
        
        //move up
        if(row>0 && board[row-1][col]==word.charAt(index)){
            board[row-1][col] = '#';
            if(existHelper(board, word, row-1, col, index+1)){
                return true;
            }
            board[row-1][col] = word.charAt(index);
        }
        
        //move down
        if(row<board.length-1 && board[row+1][col]==word.charAt(index)){
            board[row+1][col] = '#';
            if(existHelper(board, word, row+1, col, index+1)){
                return true;
            }
            board[row+1][col] = word.charAt(index);
        }
        
         //move left
        if(col>0 && board[row][col-1]==word.charAt(index)){
            board[row][col-1] = '#';
            if(existHelper(board, word, row, col-1, index+1)){
                return true;
            }
            board[row][col-1] = word.charAt(index);
        }
        
        //move right
        if(col<board[0].length-1 && board[row][col+1]==word.charAt(index)){
            board[row][col+1] = '#';
            if(existHelper(board, word, row, col+1, index+1)){
                return true;
            }
            board[row][col+1] = word.charAt(index);
        }
        
        return false;
    }
}
