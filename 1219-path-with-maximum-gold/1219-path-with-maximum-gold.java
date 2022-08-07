class Solution {
    int max=0;
    void check(int[][] grid,boolean [][] temp,int i,int j,int sum)
    {
        temp[i][j]=!temp[i][j];
        if(i-1>=0&&grid[i-1][j]>0&&temp[i-1][j]==false)
            check(grid,temp,i-1,j,sum+grid[i-1][j]);
        if(i+1<grid.length&&grid[i+1][j]>0&&temp[i+1][j]==false)
            check(grid,temp,i+1,j,sum+grid[i+1][j]);
        if(j-1>=0&&grid[i][j-1]>0&&temp[i][j-1]==false)
            check(grid,temp,i,j-1,sum+grid[i][j-1]);
        if(j+1<grid[i].length&&grid[i][j+1]>0&&temp[i][j+1]==false)
            check(grid,temp,i,j+1,sum+grid[i][j+1]);
        max=(sum>max)?sum:max;
        temp[i][j]=!temp[i][j];
    }
    public int getMaximumGold(int[][] grid) {
        int i,j;
        boolean[][] temp=new boolean[grid.length][grid[0].length];
        for(i=0;i<grid.length;i++)
        {
            for(j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]>0)
                {
                    check(grid,temp,i,j,grid[i][j]);  
                    //cout<<grid[i][j]<<" ";
                }
            }
        }
        return max;
    }
}