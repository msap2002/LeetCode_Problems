class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character>stk = new Stack<>();
        Stack<Character>stk1 = new Stack<>();
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '#'){
                if(!stk.isEmpty())
                    stk.pop();
                continue;
            }
            stk.push(s.charAt(i));
        }
        for(int i = 0;i < t.length();i++){
           if(t.charAt(i) == '#'){
               if(!stk1.isEmpty())
                   stk1.pop();
               continue;
           }
            stk1.push(t.charAt(i));
        }
        String res1 = "";
        String res2 = "";
        while(!stk.isEmpty()){
            res1 = res1 + stk.pop();
        }
        while(!stk1.isEmpty()){
            res2 = res2 + stk1.pop();
        }
        return res1.equals(res2);
    }
}