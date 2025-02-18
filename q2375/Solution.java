import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    private String pattern;
    private List<Integer> list;
    private int maxLength;
    private List<Integer> memo;

    Solution() {
        this.memo = new ArrayList<>(Arrays.asList(9, 9, 9, 9, 9, 9, 9, 9, 9));
    }

    private List<Integer> getMin(List<Integer> list1, List<Integer> list2) {
        int minLength = Math.min(list1.size(), list2.size());

        for (int idx = 0; idx < minLength; idx += 1) {
            if (list1.get(idx) == list2.get(idx)) {
                continue;
            }

            if (list1.get(idx) < list2.get(idx)) {
                return list1.subList(0, minLength);
            }

            return list2.subList(0, minLength);
        }

        return list1.subList(0, minLength);
    }

    private Boolean isValueEligible(int idx, int num) {
        if (idx == this.maxLength - 1) {
            return true;
        }

        char ch = this.pattern.charAt(idx);

        if (ch == 'I') {
            return num < this.list.get(idx + 1);
        }

        return num > this.list.get(idx + 1);
    }

    private void logic(int idx, Set<Integer> values) {
        if (idx == -1) {
            this.memo = this.getMin(new ArrayList<>(this.list), this.memo);
            return;
        }

        for (int num = 1; num < 10; num += 1) {
            if (values.contains(num)) {
                continue;
            }

            if (!(this.isValueEligible(idx, num))) {
                continue;
            }

            this.list.set(idx, num);
            values.add(num);

            this.logic(idx - 1, values);

            this.list.set(idx, null);
            values.remove(num);
        }
    }

    private String getResult() {
        List<String> stringSequence = new ArrayList<>();

        for (int num : this.memo) {
            stringSequence.add(String.valueOf(num));
        }

        return String.join("", stringSequence);
    }

    public String smallestNumber(String pattern) {
        this.pattern = pattern;
        this.maxLength = pattern.length() + 1;
        this.list = new ArrayList<>(this.maxLength);
        for (int idx = 0; idx < this.maxLength; idx += 1)
            this.list.add(null);

        this.logic(pattern.length(), new HashSet<>());

        return this.getResult();
    }
}