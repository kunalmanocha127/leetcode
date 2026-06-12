class Solution {
    public int[] pivotArray(int[] nums, int pivot){
        int n = nums.length;
        int[] op = new int[n];
        int left = 0;
        int right = n - 1;
        int i = 0;
        int j = n - 1;
        while (i < n){
            if (nums[i] < pivot) op[left++] = nums[i];
            if (nums[j] > pivot) op[right--] = nums[j];
            i++;
            j--;
        }
        while (left <= right) op[left++] = pivot;
        return op;
    }
}