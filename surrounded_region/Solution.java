package surrounded_region;

/*
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region .

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
 */
public class Solution {
public void solve(char[][] board){
		
		if(board==null || board.length==0)
		    return;
		int row = board.length;
		int col = board[0].length;
		
//		# means not be able to change to X
		for(int i=0;i<col;i++){
			if(board[0][i] == 'O'){
				board[0][i] = '#';
				dfs(board, 0, i);
			}
			
			if(board[row-1][i] == 'O'){
				board[row-1][i] = '#';
				dfs(board, row-1,i);
			}
		}
		
		for(int i=0;i<row;i++){
			if(board[i][0] =='O'){
				board[i][0] = '#';
				dfs(board, i, 0);
			}
			
			if(board[i][col-1] == 'O'){
				board[i][col-1] = '#';
				dfs(board, i, col-1);
			}
		}
		
		changeTo(board, 'O', 'X');
        
        // change # to O
        changeTo(board, '#', 'O');
	}
	
	public void dfs(char[][] board, int row, int col){
		
		if(row<0 || row>=board.length || col<0 || col>=board[0].length)
		    return;
		    
//		check up
		if(row > 0){
			if(board[row-1][col] == 'O'){
				board[row-1][col] = '#';
				dfs(board, row-1, col);
			}
		}
		
//		check down
		if(row < board.length-1){
			if(board[row+1][col] == 'O'){
				board[row+1][col] = '#';
				dfs(board, row+1, col);
			}
		}
		
//		check left
		if(col > 0){
			if(board[row][col-1] == 'O'){
				board[row][col-1] = '#';
				dfs(board, row, col-1);
			}
		}
		
//		check right
		if(col < board[0].length-1){
			if(board[row][col+1] == 'O'){
				board[row][col+1] = '#';
				dfs(board, row, col+1);
			}
		}
	}
	
	public void changeTo(char[][] board, char from, char to){
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if(board[i][j] == from){
					board[i][j] = to;
				}
			}
		}
	}
}
