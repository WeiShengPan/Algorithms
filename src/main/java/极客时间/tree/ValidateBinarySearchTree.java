package 极客时间.tree;

/**
 * leetcode-98
 * 验证二叉搜索树
 */
public class ValidateBinarySearchTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);

        TreeNode l = new TreeNode(1);
        TreeNode ll = new TreeNode(7);
        TreeNode lr = new TreeNode(4);
        TreeNode lll = new TreeNode(6);
        TreeNode llr = new TreeNode(4);
        TreeNode lrl = new TreeNode(7);

        root.left = l;
        l.left = ll;
        l.right = lr;
        ll.left = lll;
        ll.right = llr;
        lr.left = lrl;

        TreeNode r = new TreeNode(4);
        TreeNode rl = new TreeNode(8);
        TreeNode rr = new TreeNode(3);

        root.right = r;
        r.left = rl;
        r.right = rr;

        System.out.println(isValidBST(root));

    }




    public static boolean isValidBST(TreeNode root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isValid(TreeNode root, Integer min, Integer max) {

        if (root == null) {
            return true;
        }

        if (root.val <= min) {
            return false;
        }

        if (root.val >= max) {
            return false;
        }

        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
}
