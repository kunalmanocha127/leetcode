class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2-ax1) * (ay2-ay1);
        int area2 = (bx2-bx1) * (by2-by1);
        int l = Math.max(ax1, bx1);
        int r = Math.min(bx2, ax2);
        int b = Math.max(by1, ay1);
        int t = Math.min(ay2, by2);
        int rpt = 0;
        if(r>l && t>b) rpt = (r - l) * (t - b);
        return area1 + area2 - rpt;
    }
}