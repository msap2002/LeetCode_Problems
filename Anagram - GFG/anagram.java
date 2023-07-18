//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    String str = br.readLine();
		    String s1 = str.split(" ")[0];
		    String s2 = str.split(" ")[1];
		    
		    Solution obj = new Solution();
		    
		    if(obj.isAnagram(s1,s2))
		    {
		        System.out.println("YES");
		    }
		    else
		    {
		         System.out.println("NO");
		    }
		    
		    
		    
		}
	}
}
// } Driver Code Ends


class Solution
{    
    //Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String a,String b)
    {
        
        // Your code here
        HashMap<Character,Integer>map = new HashMap<>();
        for(int i = 0;i < a.length();i++){
            char key = a.charAt(i);
            if(!map.containsKey(key)){
                map.put(key,1);
            }
            else{
                int freq = map.get(key);
                map.put(key,freq + 1);
            }
        }
        for(int i = 0;i < b.length();i++){
            char key = b.charAt(i);
            if(map.containsKey(key)){
                int freq = map.get(key);
                map.put(key,freq - 1);
            }
            else{
                 return false;
            }
        }
        boolean isZero = true;
        for(Map.Entry<Character,Integer>entry : map.entrySet()){
            if(entry.getValue() != 0){
                isZero = false;
                break;
            }
        }
        if(isZero == true)
            return true;
        return false;
    }
}