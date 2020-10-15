package Leetcode.easy;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix l = new LongestCommonPrefix();
        System.out.println(l.findLongestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    public String findLongestCommonPrefix(String[] list) {
        if(list.length <= 0) {
            return "";
        }
        int index = 0;

        for(int i = 1; i < list.length; i ++) {
            char[] prev = index > 0 ?
                    list[i - 1].substring(0, index).toCharArray() :
                    list[i - 1].toCharArray();
            char[] current = list[i].toCharArray();

            index = 0;
            int size = prev.length >= current.length ?
                    current.length :
                    prev.length;

            if(size == 0) {
                return "";
            }
            for(int j = 0; j < size; j ++) {
                if(prev[j] == current[j]) {
                    index ++;
                } else if (j == 0){
                    return "";
                } else {
                    break;
                }
            }
        }

        return list[0].substring(0, index);
    }
}
