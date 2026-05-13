class Solution {
    public String maskPII(String s){
        if (s.indexOf('@') != -1){
            s = s.toLowerCase();
            int atIndex = s.indexOf('@');
            return s.charAt(0) + "*****" + s.substring(atIndex - 1);
        }
        else{
            String digits = s.replaceAll("\\D", ""); 
            String lastFour = digits.substring(digits.length() - 4);
            String[] countryMasks = {"", "+*-", "+**-", "+***-"};
            String prefix = countryMasks[digits.length() - 10];
            return prefix + "***-***-" + lastFour;
        }
    }
}