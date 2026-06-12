class Solution {
    public int maxNumberOfBalloons(String text) {
        int frq[] = new int[26];
        for(char ch:text.toCharArray()){
            frq[ch-'a']++;
        }
        int b = frq['b'-'a'];
        int a = frq['a'-'a'];
        int n = frq['n'-'a'];
        int l = frq['l'-'a']/2;
        int o = frq['o'-'a']/2;
        return Math.min(b,Math.min(a,Math.min(n,Math.min(l,o))));
    }
}