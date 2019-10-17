import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 题目解析
 * 使用查找表来解决该问题。
 * 设置一个 map 容器 record 用来记录元素的值与索引，然后遍历数组 nums。
 * 每次遍历时使用临时变量 complement 用来保存目标值与当前值的差值
 * 在此次遍历中查找 record ，查看是否有与 complement 一致的值，如果查找成功则返回查找值的索引值与当前变量的值 i
 * 如果未找到，则在 record 保存该元素与索引值 i
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 11, 7, 15};
        int[] result = twoSum(nums, 9);
        for (int i = 0; i < result.length; i++) {
            System.out.println("<<<--------------@@@" + result[i]);
        }
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> record = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];
            if (record.containsKey(complement)) {
                return new int[]{record.get(complement), i};
            }
            record.put(nums[i], i);
        }
        return null;
    }

}