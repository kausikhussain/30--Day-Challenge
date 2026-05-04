/*
Problem: N-Queens
Platform: LeetCode
Topic: Backtracking

Approach:
Use backtracking to place queens row by row.
Maintain three boolean arrays to keep track of columns and the two diagonals
(main diagonal and anti-diagonal) to ensure no two queens threaten each other.
Main diagonal (row - col) is constant for a diagonal. Add n to avoid negative indices.
Anti-diagonal (row + col) is constant for the other diagonal.
If we reach the nth row, a valid configuration is found.

Time Complexity: O(N!)
Space Complexity: O(N) for recursion stack and state arrays.
*/

import java.util.ArrayList;
import java.util.List;

class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        boolean[] cols = new boolean[n];
        boolean[] d1 = new boolean[2 * n]; // row + col
        boolean[] d2 = new boolean[2 * n]; // row - col + n
        
        backtrack(result, board, 0, n, cols, d1, d2);
        return result;
    }
    
    private void backtrack(List<List<String>> result, char[][] board, int row, int n, 
                           boolean[] cols, boolean[] d1, boolean[] d2) {
        if (row == n) {
            result.add(constructBoard(board));
            return;
        }
        
        for (int col = 0; col < n; col++) {
            int id1 = row + col;
            int id2 = row - col + n;
            
            if (cols[col] || d1[id1] || d2[id2]) continue;
            
            board[row][col] = 'Q';
            cols[col] = true;
            d1[id1] = true;
            d2[id2] = true;
            
            backtrack(result, board, row + 1, n, cols, d1, d2);
            
            board[row][col] = '.';
            cols[col] = false;
            d1[id1] = false;
            d2[id2] = false;
        }
    }
    
    private List<String> constructBoard(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
}
