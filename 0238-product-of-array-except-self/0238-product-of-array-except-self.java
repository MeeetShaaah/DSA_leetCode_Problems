class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];

        for(int i = 0, temp = 1; i< nums.length; i++){
            answer[i] = temp;
            temp *=nums[i];
        }

        for(int i=nums.length-1, temp=1; i>=0; i--){
            answer[i]*= temp;
            temp *=nums[i];
        }
        return answer;
    }
}