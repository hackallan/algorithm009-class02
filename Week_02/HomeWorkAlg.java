package structure.work02;

import java.util.*;

/**
 * func：
 *
 * @Author： allanQin
 * @Date: 2020/5/25 15:49
 */
public class HomeWorkAlg {

    public static void main(String[] args) {
        HomeWorkAlg fun = new HomeWorkAlg();
        //fun.isAnagram2("anagram", "nagaram");
//        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        fun.groupAnagrams1(strs);


    }


    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 方法1 暴力法
     * 时间复杂度O(n) 空间复杂度O(n)
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {

        //1、暴力法 将字符串sort后判断两者是否相等

        String[] sarray = s.split("");
        String[] tarray = t.split("");
        Arrays.sort(sarray);
        Arrays.sort(tarray);
        boolean result = true;
        if (sarray.length == tarray.length) {

            for (int i = 0; i < sarray.length; i++) {

                if (!sarray[i].equals(tarray[i])) {
                    result = false;
                    break;
                }
            }
        } else {
            result = false;
        }

        return result;


        //用char 更快更省空间
//        if (s.length() != t.length()) {
//            return false;
//        }
//        char[] str1 = s.toCharArray();
//        char[] str2 = t.toCharArray();
//        Arrays.sort(str1);
//        Arrays.sort(str2);
//        return Arrays.equals(str1, str2);

    }

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 方法2 链表法
     * 时间复杂度O() 空间复杂度O()
     * 一个加 一个减
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {

        Map<String, Integer> map = new HashMap();

        String[] sarray = s.split("");
        String[] tarray = t.split("");
        for (int i = 0; i < sarray.length; i++) {

            if (map.containsKey(sarray[i])) {
                map.put(sarray[i], map.get(sarray[i]) + 1);
            } else {
                map.put(sarray[i], 1);
            }
        }

        for (int i = 0; i < tarray.length; i++) {
            if (map.containsKey(tarray[i])) {
                Integer integer = map.get(tarray[i]);
                if (integer == 1) {
                    map.remove(tarray[i]);
                } else {
                    map.put(tarray[i], integer - 1);
                }

            } else {
                map.put(tarray[i], 1);
            }
        }

        return map.size() == 0;
    }


    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 方法3 26个字母数组法
     * 时间复杂度：O(n)。时间复杂度为 O(n)O(n) 因为访问计数器表是一个固定的时间操作。
     * 空间复杂度：O(1)。尽管我们使用了额外的空间，但是空间的复杂性是 O(1)O(1)，因为无论 NN 有多大，表的大小都保持不变。
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/valid-anagram/solution/you-xiao-de-zi-mu-yi-wei-ci-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram3(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] arrays = new int[26];

        for (int i = 0; i < s.length(); i++) {

            arrays[s.charAt(i) - 'a']++;

        }

        for (int i = 0; i < t.length(); i++) {
            arrays[t.charAt(i) - 'a']--;

            if (arrays[t.charAt(i)] < 0) {
                return false;
            }
        }

        return true;

    }


    /**
     * 不通过，java.lang.OutOfMemoryError: Java heap space
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams1(String[] strs) {

        List<List<String>> list = new ArrayList();

        boolean isPut = false;
        for (int i = 0; i < strs.length; i++) {

            String item = strs[i];

            if (list.size() > 0) {
                char[] charArray = item.toCharArray();
                for (int j = 0; j < list.size(); j++) {

                    List<String> listItem = list.get(j);
                    for (int k = 0; k < listItem.size(); k++) {

                        String str = listItem.get(k);
                        char[] chars = str.toCharArray();
                        Arrays.sort(chars);
                        Arrays.sort(charArray);
                        boolean equals = Arrays.equals(chars, charArray);
                        if (equals) {
                            listItem.add(item);
                            isPut = true;
                        } else {
                            isPut = false;
                        }

                    }
                }

                if (!isPut) {
                    List<String> subL = new ArrayList<String>();
                    subL.add(item);
                    list.add(subL);
                    isPut = true;
                }
            } else {

                List<String> subL = new ArrayList<String>();
                subL.add(item);
                list.add(subL);
                isPut = true;
            }


        }

        return list;
    }

    /**
     * 字母异位词分组
     * 方法2
     * 时间复杂度：O(NKlogK)，其中 N 是 strs 的长度，而 K 是 strs 中字符串的最大长度。当我们遍历每个字符串时，外部循环具有的复杂度为 O(N)。然后，我们在 O(KlogK) 的时间内对每个字符串排序。
     * 空间复杂度：O(NK)，排序存储在 ans 中的全部信息内容。
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/group-anagrams/solution/zi-mu-yi-wei-ci-fen-zu-by-leetcode/
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) return new ArrayList();

        //hash表存放 key 和对应的集合
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());

            }

            ans.get(key).add(s);
        }

        return new ArrayList(ans.values());
    }


    /**
     * 26个字母法
     * 时间复杂度 O(NK) ，N是strs的长度，K是strs中字符的最大长度
     * 空间复杂度 O(NK)
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams3(String[] strs) {

        if (strs.length == 0) return new ArrayList();

        Map<String, List> list = new HashMap<String, List>();

        int[] count = new int[26];
        Arrays.fill(count, 0);
        for (String item : strs) {

            char[] chars = item.toCharArray();
            for (char c :
                    chars) {
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                //拼接

                sb.append("#");
                sb.append(count[i]);
            }

            String key = sb.toString();
            if (!list.containsKey(key)) {
                list.put(key, new ArrayList());
            }

            list.get(key).add(item);
        }

        return new ArrayList(list.values());
    }


}
