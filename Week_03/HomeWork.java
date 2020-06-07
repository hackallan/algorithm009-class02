package structure.work03;

import java.util.*;

/**
 * func：
 *
 * @Author： allanQin
 * @Date: 2020/6/6 16:03
 */
public class HomeWork {


    /**
     * 根据一颗树的前序遍历与中序遍历构造二叉树
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //前序遍历的第一个节点也就是根节点，中序中根节点左边的是根节点的左子节点，右边的是右子节点；一次递归下去就可以构造二叉树

        int n = preorder.length;

        indexMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);//将中序的值和位置插入map中，为了到时候直接找到根的位置
        }

        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {

        if (preorder_left > preorder_right) {
            return null;
        }

        //前序遍历的第一个节点就是根节点
        int preorder_root = preorder_left;
        //中序遍历中定位根的位置
        Integer inorder_root = indexMap.get(preorder_root);

        //建立根节点
        TreeNode root = new TreeNode(preorder[preorder_root]);

        //得到左子树节点数目
        int size_left_subtree = inorder_root - inorder_left;


        //递归的构造左子树，并且链接到根节点

        //先序遍历中【从 左边界 + 1 开始的】的元素对应了中序遍历中【从根节点 -1 到根节点】 的元素
        //preorder = [3,9,20,15,7]
        // inorder = [9,3,25,20,7] 指的就是前序的9 对应 inorder中的9的位置

        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);

        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);

        return root;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 0; i < preorder.length; i++) {
            int preorderVal = preorder[i];

            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);

                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }

                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }


        }

        return root;

    }

    /**
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {

        this.n = n;
        this.k = k;
        combineHelper(1, new LinkedList<Integer>());
        return combineRes;
    }

    public List<List<Integer>> combineRes = new LinkedList();

    int n;
    int k;

    public void combineHelper(int index, LinkedList<Integer> curr) {

        if (curr.size() == this.k) {
            combineRes.add(new LinkedList(curr));
        }

        for (int i = index; i <= n; i++) {
            curr.add(i);
            combineHelper(i + 1, curr);

            curr.removeLast();
        }

    }


    List<List<Integer>> sortList = new LinkedList();

    /**
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList();

        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int num : nums)
            output.add(num);

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    private void backtrack(int n, ArrayList<Integer> output, List<List<Integer>> res, int first) {

        //所有填完毕
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(output, first, i);

            //go next
            backtrack(n, output, res, first + 1);
            //undo op
            Collections.swap(output,first,i
            );
        }

    }


    class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
