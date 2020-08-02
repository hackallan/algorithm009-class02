package structure.work08;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * func：
 *
 * @Author： allanQin
 * @Date: 2020/7/27 10:22
 */
public class HomeWork {

    /**
     * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        //与1 进行 与 运算不等于就证明对应的位置上为1
        int mask = 1;
        int count = 0;
        for (int i = 0; i < 32; i++) {

            if ((mask & n) != 0) {
                count++;

            }
            mask <<= 1;//向左移动1位
        }

        return count;

    }


    class LRUCache extends LinkedHashMap<Integer, Integer> {

        private int capacity;

        public LRUCache(int capacity) {

            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        public int get(int key) {

            return super.getOrDefault(key, -1);

        }

        public void put(int key, int value) {

            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }

}
