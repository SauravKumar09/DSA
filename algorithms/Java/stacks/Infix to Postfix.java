class Solution {
    // Function to convert an infix expression to a postfix expression.
    private static int prec(char ch){
        if(ch == '^'){
            return 3;
        }
        else if(ch == '*' || ch == '/'){
            return 2;
        }
        else if(ch == '+' || ch == '-'){
            return 1;
        }
        else{
            return -1;
        }
    }
    public static String infixToPostfix(String exp) {
        // Your code here
        StringBuilder sb = new StringBuilder();
        Stack<Character>st = new Stack<>();
        
        for(int i=0; i<exp.length(); i++){
            char ch = exp.charAt(i);
            if((ch>='a'&&ch<='z') || (ch>='A'&&ch<='Z') || (ch>='0'&&ch<='9')){
                sb.append(ch);
            }
            else if(ch == '('){
                st.push(ch);
            }
            else if(ch == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    sb.append(st.peek());
                    st.pop();
                }
                if(!st.isEmpty()){
                st.pop();
            }
        }
        else{
            while(!st.isEmpty() && prec(ch) <= prec(st.peek())){
                sb.append(st.peek());
                st.pop();
            }
            st.push(ch);
         }
    }
    while(!st.isEmpty()){
        sb.append(st.peek());
        st.pop();
    }
    return sb.toString();
    }    
}
