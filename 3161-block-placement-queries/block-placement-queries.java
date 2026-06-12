class Fenwick{
    int n;
    int[] bit;
    Fenwick(int n){
        this.n = n;
        this.bit = new int[n + 1];
    }

    void add(int idx, int val){
        for (; idx <= n; idx += idx & -idx){
            bit[idx] += val;
        }
    }

    int sum(int idx){
        int ss = 0;
        for (; idx > 0; idx -= idx & -idx){
            ss += bit[idx];
        }
        return ss;
    }

    int kth(int k){
        int idx = 0;
        int step = 1;
        while ((step << 1) <= n) step <<= 1;
        for (int d = step; d > 0; d >>= 1){
            int next = idx + d;
            if (next <= n && bit[next] < k){
                idx = next;
                k -= bit[next];
            }
        }
        return idx + 1;
    }
}

class SegTree{
    int n;
    int[] tree;
    SegTree(int n){
        this.n = n;
        this.tree = new int[Math.max(4, 4 * n)];
    }

    void update(int node, int l, int r, int pos, int val){
        if (l == r){
            tree[node] = val;
            return;
        }
        int mid = (l + r) >>> 1;
        if (pos <= mid) update(node << 1, l, mid, pos, val);
        else update(node << 1 | 1, mid + 1, r, pos, val);
        tree[node] = Math.max(tree[node << 1], tree[node << 1 | 1]);
    }

    int query(int node, int l, int r, int ql, int qr){
        if (ql > r || qr < l) return 0;
        if (ql <= l && r <= qr) return tree[node];
        int mid = (l + r) >>> 1;
        return Math.max(query(node << 1, l, mid, ql, qr),
                        query(node << 1 | 1, mid + 1, r, ql, qr));
    }
}

class Solution {
    public List<Boolean> getResults(int[][] queries) {
        int mx = 0;
        for (int[] q : queries){
            mx = Math.max(mx, q[1]);
        }
        int fws = mx + 2;
        Fenwick fw = new Fenwick(fws);
        SegTree st = new SegTree(mx + 1);
        fw.add(1, 1);
        List<Boolean> op = new ArrayList<>();
        for (int[] q : queries){
            int type = q[0];
            int x = q[1];
            if (type == 1){
                int lc = fw.sum(x);
                int lp = fw.kth(lc) - 1;
                int otx = fw.sum(x + 1);
                int toc = fw.sum(fws);
                int rp = -1;
                if (otx < toc) rp = fw.kth(otx + 1) - 1;
                st.update(1, 0, mx, x, x - lp);
                if (rp != -1) st.update(1, 0, mx, rp, rp - x);
                fw.add(x + 1, 1);
            }
            else{
                int sz = q[2];
                int lc = fw.sum(x);
                int lp = fw.kth(lc) - 1;
                int bestPrefix = st.query(1, 0, mx, 0, x);
                op.add((x - lp >= sz) || (bestPrefix >= sz));
            }
        }
        return op;
    }
}