class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int c = 0;
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i = 0;i < nums2.length;i++){
            if(nums2[i] > nums2[c]){
                map.put(nums2[c],nums2[i]);
                i = c;
                c++;
            }
            if(i + 1 == nums2.length && map.size() != nums2.length){
                map.put(nums2[c],-1);
                i = c;
                c++;
            }
        }
        int k = 0;
        int res[] = new int[nums1.length];
        for(int i = 0;i < res.length;i++){
            res[k++] = map.get(nums1[i]);
        }
        return res;
    }
}