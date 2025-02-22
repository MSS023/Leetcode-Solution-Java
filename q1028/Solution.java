package q1028;

import java.util.ArrayList;
import java.util.List;

class SequenceObject {
    int depth = 0;
    int ele;
}

class Solution {
    List<SequenceObject> seq;

    private List<SequenceObject> getEleSequence(String traversal) {
        List<SequenceObject> result = new ArrayList<>();

        SequenceObject currObject = new SequenceObject();
        int idx = 0;
        while (idx < traversal.length()) {
            if (traversal.charAt(idx) == '-') {
                currObject.depth += 1;
                idx += 1;
                continue;
            }

            String value = "";
            while (idx < traversal.length() && traversal.charAt(idx) != '-') {
                value += traversal.charAt(idx);
                idx += 1;
            }

            currObject.ele = Integer.parseInt(value);
            result.add(currObject);
            currObject = new SequenceObject();
        }

        return result;
    }

    private TreeNode createTree(int currLevel) {
        if (this.seq.size() == 0) {
            return null;
        }

        SequenceObject obj = this.seq.remove(0);

        if (obj.depth < currLevel) {
            this.seq.add(0, obj);
            return null;
        }

        TreeNode node = new TreeNode(obj.ele);
        node.left = this.createTree(currLevel + 1);
        node.right = this.createTree(currLevel + 1);

        return node;
    }

    public TreeNode recoverFromPreorder(String traversal) {
        this.seq = this.getEleSequence(traversal);

        return this.createTree(0);
    }
}
