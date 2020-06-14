package structure.work04;

import javafx.util.Pair;

import java.util.*;

/**
 * func：
 *
 * @Author： allanQin
 * @Date: 2020/6/8 20:45
 */
public class HomeWork {

    public static void main(String[] args) {
        HomeWork func = new HomeWork();

        int[] bills = {5, 20, 5, 10, 20};
        func.lemonadeChange(bills);
    }


    private int row;

    private int column;

    /**
     * https://leetcode-cn.com/problems/number-of-islands/
     * 岛屿问题
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {

        int count = 0;
        row = grid.length;
        if (row == 0) return 0;

        column = grid[0].length;
        //遍历每个点，看看是否是陆地，如果是陆地，那么将其周围是陆地的地方全设置为0，也就不用遍历除非遇到下个岛屿情况
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    ++count;
                }
            }


        }

        return count;
    }

    private void DFSMarking(char[][] grid, int i, int j) {

        if (i < 0 || j < 0 || i >= row || j >= column || grid[i][j] != '1') return;

        //如果该点为1 ，也就是陆地将其致为0。那么它的上下左右也都致为0，包括它的邻居的邻居递归下去
        grid[i][j] = '0';

        DFSMarking(grid, i, j - 1);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i + 1, j);

    }


    /**
     * https://leetcode-cn.com/problems/word-ladder/description/
     * 单词接龙 127
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {


        //对给定的 wordList 做预处理，找出所有的通用状态。将通用状态记录在字典中，键是通用状态，值是所有具有通用状态的单词。
        //计算单词的长度，为了生成这个三次的所有变形
        int L = beginWord.length();
        //遍历wordList做预处理 需要放到一个集合中去
        Map<String, List<String>> allComboList = new HashMap();
        wordList.forEach(word -> {

            for (int i = 0; i < L; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, L);
                List<String> transformatitions = allComboList.getOrDefault(newWord, new ArrayList<>());
                transformatitions.add(word);
                allComboList.put(newWord, transformatitions);
            }
        });

        //将包含 beginWord 和 1 的元组放入队列中，1 代表节点的层次。我们需要返回 endWord 的层次也就是从 beginWord 出发的最短距离。
        Queue<Pair<String, Integer>> queue = new LinkedList();
        queue.add(new Pair(beginWord, 1));

        //为了防止出现环，使用访问数组记录。
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        //循环队列
        while (!queue.isEmpty()) {

            // 当队列中有元素的时候，取出第一个元素，记为 current_word。
            Pair<String, Integer> node = queue.remove();
            //找到 current_word 的所有通用状态，并检查这些通用状态是否存在其它单词的映射，这一步通过检查 all_combo_dict 来实现。
            String current_word = node.getKey();
            Integer level = node.getValue();
            for (int i = 0; i < L; i++) {
                // 从 all_combo_dict 获得的所有单词，都和 current_word 共有一个通用状态，所以都和 current_word 相连，因此将他们加入到队列中。
                String newWord = current_word.substring(0, i) + "*" + current_word.substring(i + 1, L);
                for (String haveWord : allComboList.getOrDefault(newWord, new ArrayList<>())) {
                    //对于新获得的所有单词，向队列中加入元素 (word, level + 1) 其中 level 是 current_word 的层次。
                    if (haveWord.equals(endWord)) {
                        //最终当你到达期望的单词，对应的层次就是最短变换序列的长度。
                        return level + 1;
                    }

                    if (!visited.containsKey(haveWord)) {
                        visited.put(haveWord, true);
                        queue.add(new Pair(haveWord, level + 1));
                    }
                }

            }

        }


        return 0;

    }


    /**
     * 860. 柠檬水找零
     * https://leetcode-cn.com/problems/lemonade-change/description/
     *
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {

        int five = 0;
        int ten = 0;
        for (int bill :
                bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {

                if (five == 0) return false;

                five--;
                ten++;

            } else {

                if (five > 0 && ten > 0) {

                    //if else 之间的顺序不能跌倒，必须是 five ten 先操作，然后没有ten的情况下five有三个那么就直接操作else if
                    five--;
                    ten--;

                } else if (five > 3) {
                    five -= 3;
                } else {
                    return false;
                }

            }
        }


        return true;

    }

}
