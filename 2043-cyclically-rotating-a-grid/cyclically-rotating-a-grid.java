class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int layercount = Math.min(rows, cols) / 2;
        for(int layer = 0; layer < layercount; layer++) {
            ArrayList<Integer> elements = new ArrayList<>();
            int top = layer;
            int left = layer;
            int bottom = rows - layer - 1;
            int right = cols - layer - 1;
            for(int col = left; col <= right; col++){
                elements.add(grid[top][col]);
            }
            for(int row = top + 1; row <= bottom - 1; row++){
                elements.add(grid[row][right]);
            }
            for(int col = right; col >= left; col--){
                elements.add(grid[bottom][col]);
            }
            for(int row = bottom - 1; row >= top + 1; row--){
                elements.add(grid[row][left]);
            }
            int size = elements.size();
            int p = k % size;
            for(int col = left; col <= right; col++){
                grid[top][col] = elements.get(p);
                p = (p + 1) % size;
            }
            for(int row = top + 1; row <= bottom - 1; row++){
                grid[row][right] = elements.get(p);
                p = (p + 1) % size;
            }
            for(int col = right; col >= left; col--){
                grid[bottom][col] = elements.get(p);
                p = (p + 1) % size;
            }
            for(int row = bottom - 1; row >= top + 1; row--){
                grid[row][left] = elements.get(p);
                p = (p + 1) % size;
            }
        }
        return grid;
    }
}