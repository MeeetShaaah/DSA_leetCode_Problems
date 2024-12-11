// Approvh - 1, The reason for using a static block in this code is that it initializes the map when the class is loaded, ensuring that the map is created only once and remains in memory for the lifetime of the program. In contrast, the inline approach creates and initializes the map every time the method is called, which can lead to unnecessary memory allocation and deallocation. Thus, using a static block is more efficient, especially when the map will be reused across multiple method calls.

class Solution {
    static Map<String, Integer> romanValues = new HashMap<>();
    static {
        romanValues.put("M", 1000);
        romanValues.put("D", 500);
        romanValues.put("C", 100);
        romanValues.put("L", 50);
        romanValues.put("X", 10);
        romanValues.put("V", 5);
        romanValues.put("I", 1);
    }

    public int romanToInt(String s) {
        String lastSymbol = s.substring(s.length() - 1);
        int lastValue = romanValues.get(lastSymbol);
        int total = lastValue;

        for(int i = s.length() - 2; i >= 0; i--){
            String currentSymbol = s.substring(i, i+1);
            int currentValue = romanValues.get(currentSymbol);
            if(currentValue < lastValue){
                total -= currentValue;
            }else total += currentValue;

            lastValue = currentValue;
        }    
        return total;
    }
}