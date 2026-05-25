class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int[] vis = new int[n];
        vis[0] = 1;
        int ff = 0;
        while (!q.isEmpty()){
            int idx = q.poll();
            if (idx == n-1) return true;
            int l = Math.max(ff+1, idx + minJump);
            int r = Math.min(idx + maxJump, n-1);
            for (int k = l; k <= r; k++){
                if (s.charAt(k) == '0' && vis[k] == 0){
                    vis[k] = 1;
                    q.offer(k);
                }
            }
            ff = Math.max(ff, r);
        }
        return false;
    }
}