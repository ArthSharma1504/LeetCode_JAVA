/*
You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease.

Return the index of the peak element.

Your task is to solve it in O(log(n)) time complexity.

 

Example 1:

Input: arr = [0,1,0]

Output: 1
*/

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        
        while (low < high) {
            int mid = low + (high - low) / 2; // To avoid overflow
            
            if (arr[mid] < arr[mid + 1]) {
                // The peak is on the right side
                low = mid + 1;
            } else {
                // The peak is on the left side or could be mid
                high = mid;
            }
        }
        
        // low == high will point to the peak element
        return low;
    }
}
