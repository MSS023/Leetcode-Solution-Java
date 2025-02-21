package q1261;

import java.util.HashSet;
import java.util.Set;

class FindElements {

    private TreeNode root;
    private Set<Integer> passedValues;

    public FindElements(TreeNode root) {
        this.root = root;
        this.passedValues = new HashSet<>();

        if (root != null) {
            this.root.val = 0;
        }

        this.dfs(root);
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        this.passedValues.add(node.val);

        int val = node.val;

        if (node.left != null) {
            node.left.val = val * 2 + 1;
        }

        if (node.right != null) {
            node.right.val = val * 2 + 2;
        }

        this.dfs(node.left);
        this.dfs(node.right);
    }

    public boolean find(int target) {
        return this.passedValues.contains(target);
    }
}