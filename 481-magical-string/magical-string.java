class Solution {
    public int magicalString(int n) {
        if (n == 0) return 0;
        if (n <= 3) return 1;
        StringBuilder s = new StringBuilder("122");
        int p = 2;
        char lc = '2';
        while (s.length() < n){
            int rp = s.charAt(p) - '0';
            char nc = (lc == '1') ? '2' : '1';
            for (int i = 0; i < rp; i++){
                s.append(nc);
            }
            lc = nc;
            p++;
        }
        int count = 0;
        for (int i = 0; i < n; i++){
            if (s.charAt(i) == '1') count++;
        }
        return count;
    }
}