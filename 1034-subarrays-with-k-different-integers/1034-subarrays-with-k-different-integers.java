// Approch - 2, instead of hashmap we can use frequency counter length of n, this wiill be better approach...it is same like hashmap but in effecient way.
// Approch - 1, my intuition is, this problem can be solved using sliding window and hashmap, the question arrise how ?
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k){
        int left = 0;
        int right = 0;
        int totalCount = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while(right < nums.length){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while(map.size() > k){
                map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            totalCount += right - left + 1;
            right++;
        }
        return totalCount;
    }
}