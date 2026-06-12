class Solution {
    public int earliestFinishTime(int[] SL, int[] DL, int[] SW, int[] DW){
        int minL = 3000, minW = minL, op = minW;
        int n = SL.length;
        int m = SW.length;
        for (int i = 0; i < n; i++){
            minL = Math.min(minL, SL[i] + DL[i]);
        }
        for (int i = 0; i < m; i++){
            minW = Math.min(minW, SW[i] + DW[i]);
            op = Math.min(op, Math.max(minL, SW[i]) + DW[i]);
        }
        for (int i = 0; i < n; i++){
            op = Math.min(op, Math.max(minW, SL[i]) + DL[i]);
        }
        return op;
    }
}