package q889;

public class Main {
    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.printf("%d ",root.val);
        inorderTraversal(root.right);
    }
    public static void main(String[] args) {
        int[][][] testcases = {{{1,2,4,5,3,6,7}, {4,5,2,6,7,3,1}}, {{1,2,3,4,5}, {4,3,5,2,1}}};

        for(int[][] test : testcases) {
            Solution obj = new Solution();
            TreeNode root = obj.constructFromPrePost(test[0], test[1]);
            inorderTraversal(root);
            System.out.println();
        }
    }
}
