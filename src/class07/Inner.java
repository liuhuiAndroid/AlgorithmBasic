package class07;

/**
 * 加强堆基础类型需要包一层
 */
public class Inner<T> {
    public T value;

    public Inner(T v) {
        value = v;
    }
}
