/**
 * @author: zhuanglj
 * @create: 2019-03-31 16:16
 */
public class SegmentTree<E> {

    private E[] tree;

    private E[] data;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        System.arraycopy(arr, 0, data, 0, arr.length);

        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * 在treeIndex的位置创建表示区间[l...r]的线段树
     *
     * @param treeIndex
     * @param l
     * @param r
     */
    private void buildSegmentTree(int treeIndex, int l, int r) {
        // 长度为1,只有一个元素的情况
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }

        // 左节点索引
        int leftTreeIndex = leftChild(treeIndex);
        // 右节点索引
        int rightTreeIndex = rightChild(treeIndex);

        int mid = l + (r - l) / 2;
        // 左子树：从[l..mid]区间线段树
        buildSegmentTree(leftTreeIndex, l, mid);
        // 右子树：从[mid+1..r]区间线段树
        buildSegmentTree(rightTreeIndex, mid + 1, r);

        // 逻辑处理
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        // 边界值检测
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        return data[index];
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     *
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     *
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    // 返回区间[queryL, queryR]的值
    public E query(int queryL, int queryR) {
        // 边界值检查
        if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    /**
     * 在以treeIndex为根的线段树中[l...r]的范围里， 搜索区间[queryL...querR]的值
     *
     * @param treeIndex
     * @param l
     * @param r
     * @param queryL
     * @param queryR
     * @return
     */
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        // 递归到底
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }

        int mid = l + (r - l) / 2;
        // 左节点索引
        int leftTreeIndex = leftChild(treeIndex);
        // 右节点索引
        int rightTreeIndex = rightChild(treeIndex);

        if (queryL >= mid + 1) {
            // 全落在右节点
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) {
            // 全落在左节点
            return query(leftTreeIndex, l, mid, queryL, queryR);
        }

        // 一部分在左节点
        E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        // 一部分在右节点
        E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
        return merger.merge(leftResult, rightResult);
    }

    /**
     * 将index位置的值，更新为e
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        // 边界值检测
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    private void set(int treeIndex, int l, int r, int index, E e) {
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }
        int mid = l + (r - l) / 2;
        // 左节点索引
        int leftTreeIndex = leftChild(treeIndex);
        // 右节点索引
        int rightTreeIndex = rightChild(treeIndex);
        if (index >= mid + 1) {
            set(rightTreeIndex, mid + 1, r, index, e);
        } else {
            set(leftTreeIndex, l, mid, index, e);
        }

        // 更新各个节点区间的值
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                res.append(tree[i]);
            } else {
                res.append("null");
            }
            if (i != tree.length - 1) {
                res.append(", ");
            } else {
                res.append("]");
            }
        }
        return res.toString();
    }
}
