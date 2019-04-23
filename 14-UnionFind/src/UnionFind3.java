/**
 * @author: zhuanglj
 * @create: 2019-04-23 18:09
 */

/**
 * 第三版并查集
 * 基于size的优化
 */
public class UnionFind3 implements UF {
    private int[] parent;
    // sz[i]表示以i为根的集合中元素个数
    private int[] sz;

    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];
        for (int i = 0; i < parent.length; i++) {
            // 初始化时每个节点都指向自己
            parent[i] = i;
            sz[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 查找过程，查找元素p所对应的集合编号
     * O(h)复杂度，h为树的高度
     *
     * @param p
     * @return
     */
    private int find(int p) {
        // 边界值检测
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    /**
     * 查找元素p和元素q是否所属一个集合
     * O(h)复杂度，h为树的高度
     *
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        if (sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }
}
