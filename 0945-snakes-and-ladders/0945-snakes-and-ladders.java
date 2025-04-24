class Solution {
    public int snakesAndLadders(int[][] board) {
        int n=board.length;
        //visited array to avoid revisiting the same square
        boolean[] visited = new boolean[n*n+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);//start from square 1
        visited[1]=true;
        int moves=0;//tracks the number of moves taken


        //BFS loop to explore all possible moves level by level
        while(!queue.isEmpty()){
            int size = queue.size();
            //process all squares at the current move level
            for(int i=0;i<size;i++){
                int curr = queue.poll();//current square
                //if we reach the last square, return no of moves
                if(curr == n*n){
                    return moves;
                }
                //Explore all possible dice rolls (1 to 6)
                for(int dice =1; dice<=6;dice++){
                    int next = curr+dice;
                    //if next square exceeds board size,skip
                    if(next>n*n) break;
                    //convert the sq numbers to board positins(row,col)
                    int[] pos = numToPos(next,n);
                    int row = pos[0], col = pos[1];
                    //if the square has a snake or ladder, move to its destination
                    if(board[row][col] !=-1){
                        next= board[row][col];
                    }
                    //if the sq hasn't been visited , mark it and enqueu
                    if(!visited[next]){
                        visited[next] = true;
                        queue.offer(next);
                    }
                }

            }
            moves++; //increment move count after processing each level
        }
        //if the loop completed without reaching the last sq, return -1
        return -1;
    }
    //helper function to convert sq number to (row,col) position
    private int[] numToPos(int num,int n){
        //calculate row and column in 0-indexed terms
    int row = (num-1)/n;
    int col = (num-1)%n; //col L to R
    //for odd rows (from bottom), reverse the column direction
    if(row%2==1){
        col = n-1-col;
    }
    //convert to 0-indexed row from the bottom
    row=n-1-row;
    return new int[]{row,col};
    }
}