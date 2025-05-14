class Solution{
    public int equalPairs(int[][] grid){
        int count =0;
        int n = grid.length;

        //hashmap keeps track of each frequency of each row
        Map<String, Integer> rowCounter = new HashMap<>();
        for(int[] row : grid){
            String rowString = Arrays.toString(row);
            rowCounter.put(rowString, 1 + rowCounter.getOrDefault(rowString, 0));
        }
        //lets add the frequency of each element in map
        for (int c = 0; c < n; c++) {
            int[] colArray = new int[n];
            for (int r = 0; r < n; ++r) {
                colArray[r] = grid[r][c];
            }
            count += rowCounter.getOrDefault(Arrays.toString(colArray), 0);
        }
        return count;
    }
}