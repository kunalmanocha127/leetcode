class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int x:nums) mp.put(x,mp.getOrDefault(x,0)+1);
        int op=1;
        for(int x:nums){
            if(x==1){
                if(mp.get(x)%2!=0) op=Math.max(op,mp.get(x));
                else op=Math.max(op,mp.get(x)-1);
            }
            else{
                int ct=0;
                if(mp.get(x)>=2){
                    long curr=x;
                    while(curr<=Integer.MAX_VALUE&&mp.containsKey((int)curr)){
                        if(mp.get((int)curr)==1){
                            ct++;
                            break;
                        }
                        ct++;
                        if(curr>Long.MAX_VALUE/curr) break;
                        curr*=curr;
                    }
                }
                op=Math.max(op,ct*2-1);
            }
        }
        return op;
    }
}