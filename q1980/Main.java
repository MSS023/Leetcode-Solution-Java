package q1980;

public class Main {
    public static void main(String[] args) {
        String[][] testCases = { { "00", "01" }, { "01", "10" }, { "111", "011", "001" } };

        for (String[] test : testCases) {
            Solution obj = new Solution();

            System.out.println(obj.findDifferentBinaryString(test));
        }
    }
}
