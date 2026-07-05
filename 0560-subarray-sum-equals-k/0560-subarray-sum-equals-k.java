class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int prefixSum = 0;
        int count = 0;

        map.put(0,1);

        for(int i = 0; i < nums.length; i++){
            prefixSum += nums[i];

            if(map.containsKey(prefixSum - k)){
                count += map.get(prefixSum - k);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}

// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         Map<Integer,Integer> map = new HashMap<>();// (prefixSum, frequency) mapping

//         int prefixSum = 0;
//         int count = 0;

//         map.put(0,1); //this is for the condition when the prefix sum become 0, because we are checking sum - k, which eventually gives 0 sometimes so in that case we have to add additional condition. 

//         for(int i = 0; i < nums.length; i++){
//             prefixSum += nums[i];

//             if(map.containsKey(prefixSum - k)){
//                 count += map.get(prefixSum - k);
//             }

//             map.put(prefixSum, map.getOrDefault(prefixSum, 0 ) + 1);
//         }
//         return count;
//     }
// }