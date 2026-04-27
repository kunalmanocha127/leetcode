class Solution {
    public boolean detectCapitalUse(String word) {
        boolean allUpper = word.equals(word.toUpperCase());
        boolean allLower = word.equals(word.toLowerCase());
        boolean titleCase = Character.isUpperCase(word.charAt(0)) &&
                            word.substring(1).equals(word.substring(1).toLowerCase());
        return allUpper || allLower || titleCase;
    }
}