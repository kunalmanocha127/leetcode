class Solution {
    public boolean isHappy(int n) {
        int slow = gnn(n);
        int fast = gnn(gnn(n));
        while (slow != fast){
            if (fast == 1) return true;
            slow = gnn(slow);
            fast = gnn(gnn(fast));
        }
        return slow == 1;
    }

    private int gnn(int n){
        int op = 0;
        while (n > 0){
            int digit = n % 10;
            op += digit * digit;
            n = n / 10;
        }
        return op;
    }
}