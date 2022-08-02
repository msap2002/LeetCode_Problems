class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        char rightMost;
         while(columnNumber > 0){
             columnNumber--;
             rightMost = (char)(columnNumber % 26 + 'A');
             sb.append(rightMost);
             columnNumber /= 26;
         }
        return sb.reverse().toString();
    }
}