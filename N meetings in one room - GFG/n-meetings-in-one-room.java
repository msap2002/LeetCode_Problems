//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Meeting{
    int start;
    int end;
    int pos;
    Meeting(int start,int end,int pos){
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}
class meetingComparator implements Comparator<Meeting>{
    @Override
    public int compare(Meeting o1,Meeting o2){
        if(o1.end < o2.end)
           return -1;
        else if(o1.end > o2.end)
           return 1;
        else if(o1.pos > o2.pos)
           return 1;
        return -1;
    }
}
class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        ArrayList<Meeting>meet = new ArrayList<>();
        for(int i = 0;i < start.length;i++)
           meet.add(new Meeting(start[i],end[i],i + 1));
        meetingComparator mc = new meetingComparator();
        Collections.sort(meet,mc);
        ArrayList<Integer>ans = new ArrayList<>();
        ans.add(meet.get(0).pos);
        int endLimit = meet.get(0).end;
        for(int i = 1;i < start.length;i++){
            if(meet.get(i).start > endLimit){
                endLimit = meet.get(i).end;
                ans.add(meet.get(i).pos);
            }
        }
        int count = 0;
        for(int i = 0;i < ans.size();i++)
          count++;
        return count;
    }
}
