class Solution {
    public int numberOfSpecialChars(String word) {
        int count = 0;
        char c = 'a', c1 = 'A';
        for(int i = 0; i < 26; i++){
            if(word.contains(String.valueOf(c)) && word.contains(String.valueOf(c1))) count++;
            c++;
            c1++;
        }
        return count;
    }
}