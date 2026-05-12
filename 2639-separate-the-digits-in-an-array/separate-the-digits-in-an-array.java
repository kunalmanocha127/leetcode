class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            String s = String.valueOf(num);
            for (char ch : s.toCharArray()) {
                list.add(ch - '0');
            }
        }
        int[] op = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            op[i] = list.get(i);
        }
        return op;
    }
}