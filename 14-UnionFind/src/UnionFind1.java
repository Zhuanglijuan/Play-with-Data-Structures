/**
 * @author: zhuanglj
 * @create: 2019-04-23 14:05
 */

/**
 * 第一版并查集
 * 使用数组模拟
 */
public class UnionFind1 implements UF {

    private int[] id;

    public UnionFind1(int size) {
        id = new int[size];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    // 查找元素p所对应的集合编号
    private int find(int p) {
        // 边界值检测
        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }
        return id[p];
    }

    /**
     * 查看元素p和元素q是否所属同一个集合
     * 时间复杂度O(1)
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并元素p和元素q所属的集合
     * 时间复杂度O(n)
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {
        // 已经是相连的
        if (isConnected(p, q)) {
            return;
        }
        int pID = find(p);
        int qID = find(q);

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
    }
}
