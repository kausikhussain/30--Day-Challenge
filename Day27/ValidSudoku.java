/*
Problem: Valid Sudoku
Platform: LeetCode
Topic: Hash Table / Matrix

Approach:
Use three sets of arrays (one for rows, one for columns, one for 3x3 boxes) to keep track 
of the seen numbers. The index for the 3x3 box can be calculated as `(r / 3) * 3 + (c / 3)`.
Iterate through the board and if a number is already in the set for its row, col, or box, 
it's an invalid Sudoku.

Time Complexity: O(1) since the board is always 9x9.
Space Complexity: O(1) for the fixed size arrays.
*/

class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] boxes = new int[9][9];
        
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int val = board[r][c] - '1';
                    int boxIndex = (r / 3) * 3 + (c / 3);
                    
                    if (rows[r][val] == 1 || cols[c][val] == 1 || boxes[boxIndex][val] == 1) {
                        return false;
                    }
                    
                    rows[r][val] = 1;
                    cols[c][val] = 1;
                    boxes[boxIndex][val] = 1;
                }
            }
        }
        
        return true;
    }
}
