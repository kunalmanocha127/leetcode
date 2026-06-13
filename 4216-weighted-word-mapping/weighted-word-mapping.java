class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder op = new StringBuilder();
        for (int i = 0; i < words.length; i++){
            String t = words[i];
            int ws = 0;
            for (int j = 0; j < t.length(); j++) {
                char c = t.charAt(j);
                int x = (int) c - 97;
                ws = ws + weights[x];
            }
            int m = ws % 26;
            char ch = (char) ('z' - m); 
            op.append(ch);
        }
        return op.toString();
    }
}