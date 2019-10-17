import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 */
public class MaxLenghtSubString {

    public static void main(String[] args) {
        System.out.println("<<<--------------@@@" + lengthOfSubString("abcabcbb"));
    }


    /**
     * 解题思路
     * 创建字符长度的Map
     * 将传入的字符串转换为字符数组进行遍历，遍历对map中的内容进行比较不存在放入map中
     *
     */
    private static Integer lengthOfSubString(String str) {
        Map<String, Integer> map = new HashMap<>(str.length());
        char ss[] = str.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            if (!map.containsKey(String.valueOf(ss[i]))) {
                map.put(String.valueOf(ss[i]), i);
            }
        }

        return map.size();

    }
}
