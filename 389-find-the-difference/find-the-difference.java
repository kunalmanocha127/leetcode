class Solution {
    public char findTheDifference(String s, String t) {
        char cs[] = new char[s.length()];
        char ct[] = new char[s.length()+1];
        for(int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            cs[i] = c;
        }
        for(int i = 0; i< s.length()+1; i++){
            char c = t.charAt(i);
            ct[i] = c;
        }
        Arrays.sort(cs);
        Arrays.sort(ct);
        for(int i = 0; i < cs.length;i++){
            if(cs[i] == ct[i]) continue;
            else return ct[i];
        }
        return ct[cs.length];
    }
}