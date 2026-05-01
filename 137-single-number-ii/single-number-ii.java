class Solution {
    public int singleNumber(int[] nums) {
        int b1 = 0;
        int b2 = 0;
        for (final int num : nums) {
            b1 ^= (num & ~b2);
            b2 ^= (num & ~b1);
        }
        return b1;
    }
}