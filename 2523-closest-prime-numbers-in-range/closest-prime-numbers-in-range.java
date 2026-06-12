class Solution {
    public int[] closestPrimes(int left, int right) {
        if (left > right) return new int[]{-1, -1};
        boolean[] pr = new boolean[right + 1];
        Arrays.fill(pr, true);
        pr[0] = pr[1] = false;
        for (int i = 2; i * i <= right; i++) {
            if (pr[i]) {
                for (int j = i * i; j <= right; j += i) {
                    pr[j] = false;
                }
            }
        }
        List<Integer> pn = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (pr[i]) pn.add(i);
        }
        if (pn.size() < 2) return new int[]{-1, -1};
        int md = Integer.MAX_VALUE, num1 = -1, num2 = -1;
        for (int i = 1; i < pn.size(); i++) {
            int d = pn.get(i) - pn.get(i - 1);
            if (d < md) {
                md = d;
                num1 = pn.get(i - 1);
                num2 = pn.get(i);
            }
        }
        return new int[]{num1, num2};
    }
}