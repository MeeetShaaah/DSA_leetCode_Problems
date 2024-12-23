// Approch - 2(self), traverse the array2 and find the next grater element, add that into hashmap, key will be the element and value will be the next grater one, 
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[nums1.length];

        for (int i = nums2.length-1; i >= 0; i--){

            while (!stack.isEmpty() && nums2[i] >= stack.peek()){
                stack.pop();
            }

            if(stack.isEmpty()){
                map.put(nums2[i], -1);
            }else{
                map.put(nums2[i], stack.peek());
            }

            stack.push(nums2[i]);
        }

        for(int i = 0; i < nums1.length; i++){
            result[i] = map.get(nums1[i]);
        }


        return result;
    }
}

// Approch - 1, in brute force approch, pick one element from array 1 and traverse the entire array 2, if element found from that find the next grater element with while loop, the TC will be n3; not a optimal approch.