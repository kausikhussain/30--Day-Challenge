/*
Problem: Pacific Atlantic Water Flow
Platform: LeetCode
Topic: Graphs / DFS

Approach:
Start DFS from the edges (Pacific and Atlantic) and mark reachable cells.
The cells that are reachable from both oceans are the result.
Water can flow from cell A to cell B if height(A) >= height(B), so for reverse 
reachability we check if height(next) >= height(current).

Time Complexity: O(m * n)
Space Complexity: O(m * n)
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) return res;
        
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0);
            dfs(heights, atlantic, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j);
            dfs(heights, atlantic, m - 1, j);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        
        return res;
    }
    
    private void dfs(int[][] heights, boolean[][] visited, int r, int c) {
        visited[r][c] = true;
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        for (int[] d : dirs) {
            int nr = r + d[0], nc = c + d[1];
            if (nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length 
                && !visited[nr][nc] && heights[nr][nc] >= heights[r][c]) {
                dfs(heights, visited, nr, nc);
            }
        }
    }
}
