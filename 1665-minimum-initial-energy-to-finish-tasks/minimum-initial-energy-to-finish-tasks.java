class Solution {
    public int minimumEffort(int[][] shop) {
        Arrays.sort(shop, (a, b) -> b[1] - b[0] - (a[1] - a[0]));
        int st = shop[0][1];
        int bal = shop[0][1] - shop[0][0];
        int loan = 0;
        for (int i = 1; i < shop.length; i++) {
            int cost = shop[i][0];
            int thr = shop[i][1];
            if (bal < thr) {
                loan += thr - bal;
                bal = thr;
            }
            bal -= cost;
        }
        return st + loan;
    }
}