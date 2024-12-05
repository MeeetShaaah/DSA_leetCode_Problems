class Solution {
    
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            list.add(generateRow(i));
        }
        return list;
    }

    public static List<Integer> generateRow(int rows){
        int ans = 1;
        List<Integer> list = new ArrayList<>();
        list.add(ans);

        for(int columns = 0; columns < rows; columns++){
            ans = ans * (rows - columns);
            ans = ans/(columns+1);
            list.add((int)ans);
       }
       return list;
    }
}


// Variant - 1, to find the pertular element in given specific row and column,
// class Solution {
//     public List<List<Integer>> generate(int numRows) {
//         public static long nCr(int  n, int r){
//             long res = 1;

//             for (int i = 0; i < r; i++){
//                 res = res * (n-i);
//                 res = res/ i+1;
//             }
//             return res;
//         }

//      
//         public static int pascalTriangle(int r, int c) {
//             element = (int) nCr(r-1, c-1);
//         }
//     }
// }