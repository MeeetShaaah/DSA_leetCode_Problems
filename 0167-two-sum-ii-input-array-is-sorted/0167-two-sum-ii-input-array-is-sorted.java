class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0; 
        int right = numbers.length -1;
        int sum = 0;

        while (numbers[left] + numbers[right] != target){
            if (numbers[left] + numbers[right] < target) left ++;
            else right --;
        }
        return new int[] {left+1, right+1};
    }
}