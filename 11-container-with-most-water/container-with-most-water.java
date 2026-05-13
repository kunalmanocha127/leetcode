class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int op = 0;
        while (l < r){
            int h = Math.min(height[l], height[r]);
            int w = r - l;
            op = Math.max(op, h * w);
            if (height[l] < height[r]) l++;
            else r--;
        }
        return op;
    }
}