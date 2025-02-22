package q1028;

public class Main {
    static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.val);
        System.out.print(" ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        String[] testCases = {"1-2--3--4-5--6--7", "1-2--3---4-5--6---7", "1-401--349---90--88"};

        for (String test: testCases) {
            Solution obj = new Solution();
            TreeNode node = obj.recoverFromPreorder(test);
            inorderTraversal(node);
            System.out.println();
        }
    }
}
