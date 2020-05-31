package structure.work02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * func：
 *
 * @Author： allanQin
 * @Date: 2020/5/26 16:38
 * 第6课 树、二叉树、二叉搜索树的实现和特征
 */
public class HomeWorkAlg6First {

    /**
     * 方法1 使用递归，通过一个辅助函数来实现
     * 二叉树的中序遍历 前中后顺序
     * 时间复杂度O（n），递归函数 T(n) = 2T(n/2) + 1
     * 空间复杂度最坏情况 O（n），平均情况为O（logn）
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {

        List<Integer> res = new ArrayList<Integer>();
        helper(root, res);
        return res;

    }

    /**
     * 基于栈的遍历
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {

        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode curr = root;

        while (curr != null || stack.isEmpty()) {
            while (curr != null) {

                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }

        return res;

    }

    public void helper(TreeNode root, List<Integer> res) {

        //中序遍历，先遍历左子树完结后 添加节点 再右子树

        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }

            res.add(root.val);

            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }

    /**
     * 二叉树的前序遍历
     * 根左右的顺序
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {

        LinkedList<Integer> output = new LinkedList<Integer>();

        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        if (root == null) {
            return null;
        }

        stack.add(root);

        while (!stack.isEmpty()) {

            TreeNode treeNode = stack.pollLast();//移除集合最后一个元素

            output.add(treeNode.val);

            if (treeNode.right != null) {
                //从右边先进，到时候栈先算左边的
                stack.add(treeNode.right);
            }

            if (treeNode.left != null) {
                stack.add(treeNode.left);
            }
        }

        return output;
    }

    public void helper2(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            while (root.left != null) {
                helper2(root.left, res);
            }

            while (root.right != null) {
                helper2(root.right, res);
            }

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

