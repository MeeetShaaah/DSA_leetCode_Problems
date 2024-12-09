// Approch - 2, based on the brute force approch itself, there is no way that without looking at the solution you get the idea that how to write this code, 

//Step - 1, you habe to sort the whole multidimantial array, this is the unique method,   
class Solution {
    public int[][] merge(int[][] intervals) {

        // sort the given intervals.....using Arrays.sort() itself

        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[]  b){
                return a[0] - b[0];
            }
        });

        // now We gonna pick one element using for loop and we will compare that with previous added element in arraylist, and at the same time we gonnna add that element into to list with the conditions.
        List<int[]> list = new ArrayList<>();
        
        for (int i = 0; i < intervals.length; i++) {
            // If the list is empty or the current interval does not overlap
            if (list.isEmpty() || intervals[i][0] > list.get(list.size() - 1)[1]) {
                list.add(new int[]{intervals[i][0], intervals[i][1]});
            } else {
                // Merge intervals by updating the end time of the last interval
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], intervals[i][1]);
            }
        }

        // Step 4: Convert the list to a 2D array and return
        return list.toArray(new int[list.size()][]);
    }
}

//         for (int i = 0; i < intervals.length; i++){
//             if(list.isEmpty() || intervals[i][0] > list.get(list.size() - 1).get(1)){
//                 list.add(Arrays.asList(intervals[i][0], intervals[i][1]));
//             }else {
//                 list.get(list.size()-1).set(1, Math.max(list.get(list.size()-1).get(1), intervals[i][1]));
//             }
//         }
//         return list.toArray(new int[list.size()][]);
//     }
// }

