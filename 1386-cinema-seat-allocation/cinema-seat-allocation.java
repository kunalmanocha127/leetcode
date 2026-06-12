class Solution {
    class RowInfo {
        int row;
        boolean l;
        boolean m;
        boolean r;
        
        public RowInfo(int row) {
            this.row = row;
            l = true;
            m = true;
            r = true;
        }
    }
    
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, RowInfo> infos = new HashMap<>();
        for (int[] reservedSeat : reservedSeats) {
            int row = reservedSeat[0];
            int col = reservedSeat[1];
            infos.putIfAbsent(row, new RowInfo(row));
            if (col >= 2 && col <= 5) {
                infos.get(row).l = false;
            } 
            if (col >= 4 && col <= 7) {
                infos.get(row).m = false;
            } 
            if (col >= 6 && col <= 9) {
                infos.get(row).r = false;
            }
        }
        int op = 0;
        for (Integer row : infos.keySet()) {
            RowInfo info = infos.get(row);
            op += Math.max((info.l ? 1 : 0) + (info.r ? 1 : 0), info.m ? 1 : 0);
        }
        op += (n - infos.size()) * 2;
        return op;
    }
}