class Solution {
    public boolean isValid(String s) {
        Stack<Character>stk = new Stack<>();
        for(int i = 0;i < s.length();i++){
            char ch = s.charAt(i);
            if(isOpening(ch)){
                stk.push(ch);
            }
            else{
                if(stk.isEmpty())
                    return false;
                 else if(isMatching(stk.peek(),ch))
                    stk.pop();
                else
                    return false;
            }
        }
        if(!stk.isEmpty())
            return false;
        return true;
    }
    public boolean isOpening(char c){
        if(c == '('||c == '{'||c == '[')
            return true;
        return false;
    }
    public boolean isMatching(char a,char b){
        if(a == '(' && b == ')'||a == '{' && b == '}'||a == '[' && b == ']')
            return true;
        return false;
    }
}