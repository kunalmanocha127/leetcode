class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] op = new boolean[s.length() + 1];
        op[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String w : wordDict) {
                int start = i - w.length();
                if (start >= 0 && op[start] && s.substring(start, i).equals(w)) {
                    op[i] = true;
                    break;
                }
            }
        }
        return op[s.length()];        
    }
}