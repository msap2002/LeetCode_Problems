class Solution {
    public int maxProfit(int[] prices) {
        int x=Integer.MAX_VALUE;
        int p=0;
        int m=0;
        for(int i=0;i<prices.length;i++)
        {
            if(prices[i]<x)
                x=prices[i];
            p=prices[i]-x;
            if(m<p)
                m=p;
        }
        return m;
    }
}