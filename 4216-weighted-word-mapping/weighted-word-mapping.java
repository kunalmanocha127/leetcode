class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder op = new StringBuilder();
        for (String w : words){
            int ws = 0;
            for (char ch : w.toCharArray()) ws += weights[ch - 'a'];
            int m = ws % 26;
            op.append((char)('z' - m));
        }
        return op.toString();
    }
}