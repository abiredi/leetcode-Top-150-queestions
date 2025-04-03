class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        
        int rows = board.length;
        int cols = board[0].length;
        
        // Step 1: Check the first and last rows for 'O's
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                bfs(board, 0, j);
            }
            if (board[rows - 1][j] == 'O') {
                bfs(board, rows - 1, j);
            }
        }
        
        // Step 2: Check the first and last columns for 'O's
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                bfs(board, i, 0);
            }
            if (board[i][cols - 1] == 'O') {
                bfs(board, i, cols - 1);
            }
        }
        
        // Step 3: Flip remaining 'O's to 'X' and restore 'T's to 'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    // private void dfs(char[][] board, int i, int j) {
    //     // Check boundaries and if current cell is not 'O'
    //     if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
    //         return;
    //     }
        
    //     // Mark this cell as temporarily safe ('T')
    //     board[i][j] = 'T';
        
    //     // Recursively check adjacent cells
    //     dfs(board, i + 1, j); // down
    //     dfs(board, i - 1, j); // up
    //     dfs(board, i, j + 1); // right
    //     dfs(board, i, j - 1); // left
    // }
    private void bfs(char[][] board, int i, int j) {
    int rows = board.length;
    int cols = board[0].length;
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{i, j});
    board[i][j] = 'T'; // Mark as temporarily safe

    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // Down, Up, Right, Left

    while (!queue.isEmpty()) {
        int[] current = queue.poll();
        for (int[] dir : directions) {
            int x = current[0] + dir[0];
            int y = current[1] + dir[1];
            if (x >= 0 && x < rows && y >= 0 && y < cols && board[x][y] == 'O') {
                board[x][y] = 'T'; // Mark as temporarily safe
                queue.offer(new int[]{x, y});
            }
        }
    }
}
}