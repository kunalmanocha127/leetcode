class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int a = matrix.length, b = matrix[0].length;
        for(int i = 0; i < a; i++){
            for(int j = 0; j < b; j++){
                if(matrix[i][j] == target) return true;
            }
        }
        return false;
    }
}