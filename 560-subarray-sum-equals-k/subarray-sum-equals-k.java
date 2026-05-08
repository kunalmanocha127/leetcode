class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> subArr = new HashMap<>();
        subArr.put(0, 1);
        int total = 0, count = 0;
        for (int i = 0; i < nums.length; i++){
            int n = nums[i];
            total += n;
            if (subArr.containsKey(total - k)) {
                count += subArr.get(total - k);
            }
            subArr.put(total, subArr.getOrDefault(total, 0) + 1);
        }
        return count;        
    }
}