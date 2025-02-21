package q1261;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1, null, new TreeNode(-1));

        FindElements obj = new FindElements(root);

        System.out.println(obj.find(1));
        System.out.println(obj.find(2));
    }
}
