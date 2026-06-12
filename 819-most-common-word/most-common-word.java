class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        for (String s : banned){
            set.add(s.toLowerCase());
        }
        int max = 0;
        String word = "";
        HashMap<String, Integer> wm = new HashMap<>();
        String[] p = paragraph.toLowerCase().replaceAll("[^a-z\\s]", " ").split("\\s+");
        for (String s : p){
            if (!set.contains(s)){
                int f = wm.getOrDefault(s, 0) + 1;
                wm.put(s, f);
                if (f > max) {
                    word = s;
                    max = f;
                }
            }
        }
        return word;
    }
}