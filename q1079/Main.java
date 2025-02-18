public class Main {
    public static void main(String[] args) {
        String[] testCases = { "AAB", "AAABBC", "V" };

        for (String testCase : testCases) {
            Solution obj = new Solution();

            System.out.println(obj.numTilePossibilities(testCase));
        }
    }
}