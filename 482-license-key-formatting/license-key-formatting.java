class Solution {
    public String licenseKeyFormatting(String s, int k) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = n - 1; i >= 0; i--){
            if (Character.isLetterOrDigit(s.charAt(i))){
                if (count == k){
                    sb.append('-');
                    count = 0;
                }
                sb.append(Character.toUpperCase(s.charAt(i)));
                count++;
            }
        }
        return sb.reverse().toString();
    }
}