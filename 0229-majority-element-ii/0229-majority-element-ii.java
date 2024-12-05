
// Approch - 2, use hashmap, but this approch is not optimize to O(1) TC or SC...!!  
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        int mini = (int)(nums.length) / 3 + 1;

        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) +1);
            
            if(map.get(nums[i]) == mini){
                list.add(nums[i]);
            }

            if (list.size() == 2) break;
        }
        return list;
    }
}
// Approch - 1, Brute Force  use 1 loop to traverse, 2nd loop to check the element and update the frequency, and last check the count (even if (list.size() == 2) break; because think....!!!!)