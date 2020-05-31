package structure.work02;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * func：
 *
 * @Author： allanQin
 * @Date: 2020/5/26 19:48
 * 堆 和 二叉树、图
 */
public class HomeWorkAlg6Second {


    public static void main(String[] args) {

        int[] array = {2, 23, 9, 5, 12, 6};
        HomeWorkAlg6Second fun = new HomeWorkAlg6Second();
//        int[] leastNumbers = fun.getLeastNumbers1(array, 3);
//        System.out.println(leastNumbers.length);

        int c = 2047 & 20394;

        System.out.println(c);

        int[] ints = fun.twoSum(array, 200303);
        System.out.println(ints);
    }


    public int[] twoSum(int[] nums, int target) {
        int volume = 2048;      //100000000000
        int bitMode = volume-1;//011111111111
        int [] result =new int[volume];
        for (int i=0;i<nums.length;i++){
            int c = (target - nums[i]) & bitMode;
            if (result[c]!=0){
                return new int[]{result[c]-1,i};
            }
            result[nums[i] & bitMode]=i+1;
        }
        return null;
    }


    /**
     * 最小的k位数
     * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     * 添加队列输出结果
     * 时间复杂度 O(n) 空间 O(n)
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers1(int[] arr, int k) {

        PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            minPQ.offer(arr[i]);
        }

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = minPQ.poll();
        }

        return res;
    }


    /**
     * 直接遍历法
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers2(int[] arr, int k) {

        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }


        return res;
    }
}
