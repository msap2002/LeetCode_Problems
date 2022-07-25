class Solution {
    public boolean validPalindrome(String s) {
        return isPalindrome(s,0,s.length() - 1);
    }
    public boolean isPalindrome(String str,int i,int j){
        if(i == j||j < i)
            return true;
        else if(str.charAt(i) != str.charAt(j)){
            String s = "";
            s += str.substring(0,i);
            if(i + 1 < str.length())
                s += str.substring(i + 1,str.length());
            StringBuilder input = new StringBuilder();
            input.append(s);
            input.reverse();
            String s1 = input.toString();
            if(s.equals(s1))
                return true;
            input.setLength(0);
            s = "";
            s1 = "";
            s += str.substring(0,j);
            if(j + 1 < str.length()){
                s += str.substring(j + 1,str.length());
            }
                input.append(s);
                input.reverse();
                s1 = input.toString();
                if(s.equals(s1))
                    return true;
                else
                    return false;
        }
        else
            return isPalindrome(str,i + 1,j - 1);
    }
}