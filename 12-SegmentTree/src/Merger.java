/**
 * @author: zhuanglj
 * @create: 2019-03-31 16:42
 */
public interface Merger<E> {
    E merge(E a, E b);
}
