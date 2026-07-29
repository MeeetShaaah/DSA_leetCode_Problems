class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // int[] result = new int[2];

        int i = 0;
        int j = numbers.length - 1;
        int sum = 0;

        while (i < j) {

            sum = numbers[i] + numbers[j];

            if (sum == target) {
                return new int[]{i+1, j+1};
            }

            if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[]{};
    }
}