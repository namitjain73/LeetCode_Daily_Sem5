// Last updated: 7/9/2026, 5:01:55 PM
class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for (int num : nums) {
            arr.add(num);
        }
        
        int operations = 0;
        
        while (true) {
            boolean isSorted = true;
            for (int i = 0; i < arr.size() - 1; i++) {
                if (arr.get(i) > arr.get(i + 1)) {
                    isSorted = false;
                    break;
                }
            }
            
            if (isSorted) {
                return operations;
            }
            int minSum = Integer.MAX_VALUE;
            int index = -1;
            
            for (int i = 0; i < arr.size() - 1; i++) {
                int sum = arr.get(i) + arr.get(i + 1);
                if (sum < minSum) {
                    minSum = sum;
                    index = i;
                }
            }
            arr.set(index, minSum);
            arr.remove(index + 1);
            
            operations++;
        }
    }
}