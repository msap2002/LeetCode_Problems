//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        int vis[][] = new int[n][n];
        ArrayList<String>ans = new ArrayList<>();
        if(m[0][0] == 0||m[n - 1][n - 1] == 0)
          return ans;
        findPathBetter(0,0,m,vis,"",ans);
        return ans;
    }
    public static void findPathBetter(int i,int j,int[][] m,int[][] vis,String path,ArrayList<String>ans){
        //vis[i][j] = 1;
        if(i == m.length - 1 && j == m.length - 1){
            ans.add(path);
            return;
        }
        if(i < 0||j < 0||i == m.length||j == m.length||m[i][j] == 0||vis[i][j] == 1)
           return;
        vis[i][j] = 1;
        findPathBetter(i + 1,j,m,vis,path + "D",ans);
        findPathBetter(i - 1,j,m,vis,path + "U",ans);
        findPathBetter(i,j + 1,m,vis,path + "R",ans);
        findPathBetter(i,j - 1,m,vis,path + "L",ans);
        vis[i][j] = 0;
    }
}