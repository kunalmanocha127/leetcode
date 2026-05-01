class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        for (long i = 1; i <= n; i *= 10) {
            long l = n % i;
            long c = (n / i) % 10;
            long h = n / (i * 10);
            if (c == 0) {
                count += h * i;
            } else if (c == 1) {
                count += h * i + (l + 1);
            } else {
                count += (h + 1) * i;
            }
        }
        return count;
    }
}