class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List <Integer>[] bucket = new List[nums.length+1];
        Map <Integer, Integer> freqMap = new HashMap<>();
        for(int n: nums){
            freqMap.put(n, freqMap.getOrDefault(n,0)+1);
        }
        for(int key : freqMap.keySet()){
            int freq = freqMap.get(key);
            if(bucket[freq]==null){
                bucket[freq]= new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        int[] op = new int[k];
        int c=0;
        for(int i = bucket.length -1; i>=0 && c<k; i--){
            if(bucket[i]!= null){
                for(int j:bucket[i]){
                    op[c++]=j;
                }
            }
        }
        return op;
    }
}