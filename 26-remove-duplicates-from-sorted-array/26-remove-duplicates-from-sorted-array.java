class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int i = 0;
        int k = 0;
        nums[k] = nums[i];
        i++;
        k++;
        while(i < n){
            if(nums[i] == nums[k - 1]){
                i++;
            }
            else{
                nums[k] = nums[i];
                i++;
                k++;
            }
        }
        return k;
    }
}