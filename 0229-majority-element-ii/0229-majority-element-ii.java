// Approch - 3, Extended Moor's voting Algorithm
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0;
        int count2 = 0;
        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;

        for (int num : nums){
            if (count1 == 0 && el2 != num){
                count1 = 1;
                el1 = num;
            }else if (count2 == 0 && el1 != num){
                count2 = 1;
                el2 = num;
            }else if (el1 == num) count1++;
            else if (el2 == num) count2++;
            else {count1--; count2--;}
        }

        count1 = 0;
        count2 = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int num : nums){
            if (el1 == num) count1++;
            if (el2 == num) count2++;
        }
        int mini = (int)(nums.length)/3 +1;
        if (count1 >= mini) list.add(el1);
        if (count2 >= mini) list.add(el2);

        return list;
    }
}


// Approch - 2, use hashmap, but this approch is not optimize to O(1) TC or SC...!!  
// class Solution {
//     public List<Integer> majorityElement(int[] nums) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         ArrayList<Integer> list = new ArrayList<>();

//         int mini = (int)(nums.length) / 3 + 1;

//         for (int i = 0; i < nums.length; i++){
//             map.put(nums[i], map.getOrDefault(nums[i], 0) +1);
            
//             if(map.get(nums[i]) == mini){
//                 list.add(nums[i]);
//             }

//             if (list.size() == 2) break;
//         }
//         return list;
//     }
// }

// Approch - 1, Brute Force  use 1 loop to traverse, 2nd loop to check the element and update the frequency, and last check the count (even if (list.size() == 2) break; because think....!!!!)