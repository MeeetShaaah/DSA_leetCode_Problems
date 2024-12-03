//Appoch - 3, Using Moor's voting Algorithm's

class Solution {
    public int majorityElement(int[] nums) {
        int element = 0;
        int counter = 0;

        for (int num : nums){
            if (counter == 0){
                counter ++;
                element = num;
            }else if (element == num) counter ++;
            else counter --;
        }

        int newCounter = 0;
        for (int num : nums){
            if (element == num) newCounter ++;
        }

        if (newCounter > nums.length / 2) return element;

        return -1;
    }
}
// -------------------------------------------------------------------------------------------
// Approch - 2, Using Hash Map

// class Solution {
//     public int majorityElement(int[] nums) {
//         Map<Integer, Integer> map = new HashMap<>();

//         for (int num : nums){
//             if (map.containsKey(num)){
//                 map.put(num, map.get(num) + 1);
//             } else map.put(num, 1);
//         }

//         int majority = nums.length / 2;

//         for (Map.Entry<Integer, Integer> entry : map.entrySet()){
//             if (entry.getValue() > majority) return entry.getKey();
//         }

//         return -1;
//     }
// }


// ----------------------------------------------------------------------------------------
// Approch - 1, Brute force algorithm, use 2 for loops, 1st for loop to pick the element and 2nd for compare that with other elements and increase the count, if the count is > (n/2) return that element....!!!