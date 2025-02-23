package q889;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private int getLeftRightSubtreeSepIdx(int[] preorder, int[] postOrder) {
        List<Integer> stack = new ArrayList<>();
        int postIdx = 0;
        for (int idx = 1; idx < preorder.length; idx += 1) {
            stack.add(preorder[idx]);
            while (stack.size() > 0) {
                if (postOrder[postIdx] != stack.getLast())
                    break;
                postIdx += 1;
                stack.removeLast();
            }

            if (stack.size() == 0)
                return idx;
        }

        return preorder.length - 1;
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if (preorder.length == 0 || postorder.length == 0) {
            return null;
        }

        int rootEle = preorder[0];

        TreeNode root = new TreeNode(rootEle);
        int leftRightSubtreeSepIdx = this.getLeftRightSubtreeSepIdx(preorder, postorder);

        int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, leftRightSubtreeSepIdx + 1);
        int[] leftPostOrder = Arrays.copyOfRange(postorder, 0, leftRightSubtreeSepIdx);
        root.left = this.constructFromPrePost(leftPreOrder, leftPostOrder);

        int[] rightPreOrder = Arrays.copyOfRange(preorder, leftRightSubtreeSepIdx + 1, preorder.length);
        int[] rightPostOrder = Arrays.copyOfRange(postorder, leftRightSubtreeSepIdx, postorder.length - 1);
        root.right = this.constructFromPrePost(rightPreOrder, rightPostOrder);

        return root;
    }
}
