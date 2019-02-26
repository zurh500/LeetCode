import java.util.Arrays;
import java.util.HashMap;

/*
给定一个整数数组 nums 和一个目标值 target，
请你在该数组中找出和为目标值的那 两个 整数，
并返回他们的数组下标。
 */
public class TwoSum1 {
    public static int[] twoSum(int[] nums, int target) {
        /*
            1、暴力法
            2、两边哈希表
            3、一遍哈希表
         */
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == target - nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
//        return null;
        throw new IllegalArgumentException("没有两个数满足");
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 11, 15};
        System.out.println(Arrays.toString(twoSum3(arr, 9)));
    }

    public static int[] twoSum2(int[] nums, int target) {
        /*
            两遍哈希表
            使用数组中的值作为键存入hashMap，根据指定键对比值进行比较
            两次遍历数组
            时间复杂度是O(n)
         */
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);//值作为键  i角标作为值
        }
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i]; //声明另一个数
            //第二个条件表示一个元素不能重复利用
            if (map.containsKey(another) && map.get(another) != i) {
                //i表示map中的第几圈 第二个表示符合条件的索引输多少  get根据指定键返回值
                return new int[]{i, map.get(another)};
            }
        }
        throw new IllegalArgumentException("没有两个数满足");


    }
    public static int[] twoSum3(int[] nums, int target) {
        /*
           一遍哈希表
           将最后结果保存到hashmap中 遍历一边数组 直接判断
         */
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            if(map.containsKey(another)){ //如果集合中包含元素
                return new int[]{map.get(another),i}; //返回该元素的索引值  i是满足的索引值 因为第i次才找到满足的
            }
            map.put(nums[i], i); //正常向集合中存入数组中的数据
        }
        throw new IllegalArgumentException("没有两个数满足");
    }

}
