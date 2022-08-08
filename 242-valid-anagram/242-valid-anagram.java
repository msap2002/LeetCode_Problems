class Solution {
    public boolean isAnagram(String s, String t) {
    //     ArrayList<String> list = new ArrayList<>();
    //     permute(s,0,list,s.length() - 1);
    //     for(int i = 0;i < list.size();i++){
    //         if(list.get(i).equals(t))
    //             return true;
    //     }
    //     return false;
    // }
    // public static String swap(String s,int i,int j){
    //     char temp; 
    //     char[] charArray = s.toCharArray(); 
    //     temp = charArray[i] ; 
    //     charArray[i] = charArray[j]; 
    //     charArray[j] = temp; 
    //     return String.valueOf(charArray); 
    // }
    // public static void permute(String s,int start,ArrayList<String>list,int end){
    //     if(start == end){
    //         list.add(s);
    //         return;
    //     }
    //     for(int i = start;i < s.length();i++){
    //         s = swap(s,start,i);
    //         permute(s,start + 1,list,end);
    //         s = swap(s,start,i);
    //     }
        char arr1[] = s.toCharArray();
        char arr2[] = t.toCharArray();
        Arrays.sort(arr2);
        Arrays.sort(arr1);
        s = new String(arr1);
        t = new String(arr2);
        if(s.equals(t))
            return true;
        return false;
     }
        
}