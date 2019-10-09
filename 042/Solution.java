class Solution {
    public int trap(int[] height) {
        int ret = 0;
        int len = height.length;
        if (len==0) return 0;
        int left = 0;
        int right = left+1;
        while (left<len) {
            boolean foundPit = false;
            right = len-1;
            while (right>=left+1) {
                int minIdx = height[left]<=height[right] ? left : right;
                int area = 0;
                foundPit = true;
                for (int j=left+1; j<right; j++) {
                    if (height[j]>height[left] || height[j]>height[right]) {
                        foundPit = false;
                        break;
                    }
                    area += height[minIdx] - height[j];
                }
                if (foundPit) {
                    ret += area;
                    left = right;
                    right = left+1;
                    break;
                }
                right--;
            }
            if (foundPit) {
                continue;
            }
            else {
                left++;
            }
        }
        return ret;
    }
}

// Runtime: 3 ms, faster than 18.97% of Java online submissions for Trapping Rain Water.
// Memory Usage: 37.3 MB, less than 98.63% of Java online submissions for Trapping Rain Water.
