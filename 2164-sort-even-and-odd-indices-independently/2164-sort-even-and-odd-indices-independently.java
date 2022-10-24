class Solution {
    public int[] sortEvenOdd(int[] nums) {
        ArrayList<Integer>even = new ArrayList<>();
        ArrayList<Integer>odd = new ArrayList<>();
        int ans[] = new int[nums.length];
        for(int i = 0;i < nums.length;i++){
            if(i % 2 == 0){
                even.add(nums[i]);
            }
            else{
                odd.add(nums[i]);
            }
        }
        Collections.sort(even);
        Collections.sort(odd);
        Collections.reverse(odd);
        int k = 0,j = 0;
        for(int i = 0;i < ans.length;i++){
            if(i % 2 == 0){
                ans[i] = even.get(j++);
            }
            else{
                ans[i] = odd.get(k++);
            }
        }
        return ans;
    }
}