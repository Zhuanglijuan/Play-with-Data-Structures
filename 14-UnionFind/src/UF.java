/**
 * @author: zhuanglj
 * @create: 2019-04-23 13:31
 */
public interface UF {

    int getSize();

    /**
     * 查看元素p和元素q是否所属同一个集合
     * @param p
     * @param q
     * @return
     */
    boolean isConnected(int p, int q);

    void unionElements(int p, int q);
}
