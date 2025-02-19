package q1415;

class Solution {
    private int maxLength;
    private String memo;
    private int maxDepth;
    private int count = 0;
    private String[] characters = { "a", "b", "c" };

    private void mainLogic(String currString) {
        if (currString.length() == this.maxLength) {
            this.memo = currString;
            count += 1;
            return;
        }

        int len = currString.length();

        for (String ch : this.characters) {
            if (len > 0 && ch.equals(currString.substring(len - 1, len))) {
                continue;
            }

            this.mainLogic(currString + ch);

            if (count == this.maxDepth) {
                break;
            }
        }
    }

    public String getHappyString(int n, int k) {
        Double maxPermutations = 3 * (Math.pow(2, n - 1));

        if (k > maxPermutations) {
            return "";
        }

        this.maxLength = n;
        this.maxDepth = k;

        this.mainLogic("");

        return this.memo;
    }
}
