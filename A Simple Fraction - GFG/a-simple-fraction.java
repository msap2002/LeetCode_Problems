//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int numerator = Integer.parseInt(S[0]);
            int denominator = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            String ans = ob.fractionToDecimal(numerator, denominator);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String  fractionToDecimal(int numerator, int denominator)
    {
        // code here
        // double res = (double)numerator / (double)denominator;
        // String ans = "";
        // ans += Double.toString(res);
        // int i = 0;
        // while(ans.charAt(i) != '.'){
        //     ans = ans + ans.charAt(i);
        //     i++;
        // }
        // String res1 = ans.substring(i + 1);
        // HashMap<Character,Integer>map = new HashMap<>();
        // for(int x = 0;x < res1.length();x++){
        //     map.put(res1.charAt(x),map.getOrDefault(res1.charAt(x),0) + 1);
        // }
        // String ans2 = "";
        // for(Map.Entry<Character,Integer>entry : map.entrySet()){
        //     if(entry.getValue() > 1){
        //         ans2 += "(" + Integer.toString(entry.getKey()) + ")";
        //     }
        //     else{
        //         ans2 += Integer.toString(entry.getKey());
        //     }
        // }
        // ans = ans + "." + ans2;
        // return ans;
         if (numerator == 0) {
            return "0";
        }

        StringBuilder ans = new StringBuilder();
        // Handle sign
        if ((numerator < 0) ^ (denominator < 0)) {
            ans.append("-");
        }

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Integer part
        ans.append(num / den);
        num %= den;

        // If no fractional part, return now
        if (num == 0) {
            return ans.toString();
        }

        ans.append(".");

        Map<Long, Integer> map = new HashMap<>();
        while (num != 0) {
            // If we encounter the same remainder again, it's a recurring decimal
            if (map.containsKey(num)) {
                int index = map.get(num);
                ans.insert(index, "(");
                ans.append(")");
                break;
            }

            map.put(num, ans.length());

            num *= 10;
            ans.append(num / den);
            num %= den;
        }

        return ans.toString();
    }
}