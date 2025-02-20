package q1980;

public class Solution {
    private boolean contains(String[] arr, String value) {
        for (String ele : arr) {
            if (ele.equals(value)) {
                return true;
            }
        }

        return false;
    }

    private String formatValue(String value, int length) {
        String result = value;

        for (int idx = 0; idx < length - value.length(); idx += 1) {
            result = "0" + result;
        }

        return result;
    }

    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;

        Double maxNum = Math.pow(2, n);

        for (int num = 0; num < maxNum; num += 1) {
            String b = this.formatValue(Integer.toBinaryString(num), n);

            if (this.contains(nums, b)) {
                continue;
            }

            return b;
        }

        return "";
    }
}
