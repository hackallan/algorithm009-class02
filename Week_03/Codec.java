package structure.work03;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * func：
 *
 * @Author： allanQin
 * @Date: 2020/6/4 10:27
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        return rserializer(root, "");
    }

    public String rserializer(TreeNode root, String str) {
        if (root == null) {
            str += "null,";
        } else {
            str += str.valueOf(root.val) + ",";
            str = rserializer(root.left, str);
            str = rserializer(root.right, str);
        }

        return str;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] array = data.split(",");
        LinkedList<String> data_list = new LinkedList<String>(Arrays.asList(array));
        return rdeserialize(data_list);
    }

    public TreeNode rdeserialize(List<String> list) {
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);

        root.left = rdeserialize(list);
        root.right = rdeserialize(list);

        return root;
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
