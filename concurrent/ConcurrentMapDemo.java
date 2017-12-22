
/**
 * 比map多的四个方法，提供了更灵活的原子操作：
 * 1.V putIfAbsent(K key,V value) 如果不存在key对应的值，则将value以key加入map。
 * 2.boolean remove(Object key,Object value) 只有目前将键的条目映射到给定值时，才移除该键的条目
 * 3.boolean replace(K key,V oldValue,V newValue) 只有目前将键的条目映射到给定值时，才替换该键的条目
 * 4.V replace(K key,V value) 只有当前键存在的时候更新此键对应的值
 */
public class ConcurrentMapDemo {

}
