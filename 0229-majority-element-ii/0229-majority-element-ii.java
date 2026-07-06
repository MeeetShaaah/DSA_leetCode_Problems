class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int element1 = -1;
        int element2 = -1;
        int cnt1 = 0;
        int cnt2 = 0;
                                                                                
        for(int num : nums){
            if(num == element1){
                cnt1++;
            }else if(num == element2){
                cnt2++;
            }else if(cnt1 == 0){
                element1 = num;
                cnt1++;
            }else if(cnt2 == 0){
                element2 = num;
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }
        }

        List<Integer> list = new ArrayList<>();

        cnt1 = 0;
        cnt2 = 0;

        for(int num : nums){
            if(num == element1){
                cnt1++;
            }else if(num == element2){
                cnt2++;
            }
        }

        int min = nums.length/3;
        if(cnt1 > min){
            list.add(element1);
        }
        
        if(cnt2 > min){
            list.add(element2);
        }

        return list;
    }
}