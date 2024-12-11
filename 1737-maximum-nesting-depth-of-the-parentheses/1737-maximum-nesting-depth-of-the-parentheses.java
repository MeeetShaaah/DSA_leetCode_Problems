// Approch - 2, instead of stack we can use pointer to increment and decrement,
class Solution {
    public int maxDepth(String s) {
        int max = 0;
        int counter = 0;

        for (char c : s.toCharArray()){
            if (c == '('){
                counter ++;
            }else if (c == ')'){
                counter --;
            }

            max = Math.max(counter, max);
        }
        return max;
    }
}

// Approch - 1, using stack
// class Solution {
//     public int maxDepth(String s) {
//         Stack<Character> stack = new Stack<>();
//         int max = 0;
//         for ( char c : s.toCharArray()){
//             if (c == '('){
//                 stack.push('(');
//             }else if (c == ')'){
//                 stack.pop();
//             }

//             max = Math.max(max, stack.size());
//         }
//         return max;
//     }
// }