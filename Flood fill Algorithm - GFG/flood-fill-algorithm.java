//{ Driver Code Starts
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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here 
        int n = image.length;
        int m = image[0].length;
        int iniColor = image[sr][sc];
        int vis[][] = new int[n][m];
        int[][] ans = new int[n][m];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                ans[i][j] = image[i][j];
            }
        }
        dfs(sr,sc,image,ans,vis,newColor,iniColor);
        return ans;
    }
    public void dfs(int row,int col,int[][] image,int[][] ans,int[][] vis,int newColor,int iniColor){
        vis[row][col] = 1;
        ans[row][col] = newColor;
        int n = image.length;
        int m = image[0].length;
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        for(int i = 0;i < 4;i++){
            int ro = row + delRow[i];
            int co = col + delCol[i];
            if(ro >= 0 && ro < n && co >= 0 && co < m && image[ro][co] == iniColor && vis[ro][co] == 0){
                dfs(ro,co,image,ans,vis,newColor,iniColor);
            }
        }
    }
}