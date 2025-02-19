package q1415;

public class Main {
    public static void main(String[] args) {
        // int[][] testCases = { { 1, 3 }, { 1, 4 }, { 3, 9 } };

        int[][] testCases = { { 3, 9 } };

        for (int[] test : testCases) {
            Solution obj = new Solution();
            String out = obj.getHappyString(test[0], test[1]);
            System.out.println(out);
        }
    }
}
