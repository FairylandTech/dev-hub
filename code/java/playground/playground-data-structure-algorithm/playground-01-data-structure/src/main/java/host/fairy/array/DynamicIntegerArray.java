/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-31 11:13:11 UTC+08:00
 ****************************************************/
package host.fairy.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * 动态数组
 *
 * @author Lionel Johnson
 */
public class DynamicIntegerArray implements Iterable<Integer> {
    private Integer index = 0;
    private Integer[] array = {};
    private Integer size = 8;
    
    /**
     * 自动扩容
     */
    private void ensureCapacity() {
        if (index == 0) {
            array = new Integer[size];
        } else if (index.equals(size)) {
            size += size >> 1;
            Integer[] newArray = new Integer[size];
            System.arraycopy(array, 0, newArray, 0, index);
            array = newArray;
        }
    }
    
    /**
     * 验证索引是否合法
     *
     * @param index 索引
     */
    private void validateIndex(Integer index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
    
    /**
     * 添加元素
     *
     * @param value 值
     */
    public void add(Integer value) {
        ensureCapacity();
        array[index++] = value;
    }
    
    /**
     * 在指定索引添加元素
     *
     * @param index 索引
     * @param value 值
     */
    public void add(Integer index, Integer value) {
        if (index >= size) {
            
            this.index = size;  // 如果index在size之外，就强制扩容
        }
        ensureCapacity();
        if (array[index] != null) {
            Integer[] newArray = new Integer[size];
            System.arraycopy(array, 0, newArray, 0, index);
            newArray[index] = value;
            System.arraycopy(array, index, newArray, index + 1, this.index - index);
            array = newArray;
            this.index++;
            return;
        }
        
        array[index] = value;
        this.index++;
    }
    
    /**
     * 获取指定索引元素
     *
     * @param index 索引
     * @return 值
     */
    public Integer get(Integer index) {
        validateIndex(index);
        return array[index];
    }
    
    /**
     * 删除指定索引元素
     *
     * @param index 索引
     * @return 被删除的值
     */
    public Integer remove(Integer index) {
        validateIndex(index);
        Integer value = array[index];
        System.arraycopy(array, index + 1, array, index, this.index - index - 1);
        this.index--;
        
        return value;
    }
    
    /**
     * 匿名内部类 - 迭代器
     * 获取当前元素个数
     *
     * @return 元素个数
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;
            
            @Override
            public boolean hasNext() {  // 有没有下一个元素
                return i < index;
            }
            
            @Override
            public Integer next() {  // 返回当前元素, 指针移动下一个元素
                return array[i++];  // 先返回当前索引, 再自增
            }
        };
    }
    
    /**
     * 流式处理
     *
     * @return 流
     */
    public Stream<Integer> stream() {
        return Arrays.stream(array, 0, index);
    }
    
    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
