package AM_getSpecialString;

import java.util.Stack;

public class Solution {

    public String getSpecialString(String input){

        if(input.length() == 0) return input;
        Stack<Character> stack = new Stack();

        char[] inputArray = input.toCharArray();
        if(inputArray.length == 1){
            if(inputArray[0] == 'z') return "-1";
            else{
                inputArray[0] = (char)(inputArray[0] + 1);
                return String.valueOf(inputArray);
            }
        }

        for(int i = 0; i < inputArray.length; i++){
            if(!stack.isEmpty() && stack.peek() == inputArray[i]){
                stack.push(inputArray[i]);
                break;
            }
            stack.push(inputArray[i]);
        }

        return getLexicographicalNextString(stack, inputArray.length);
    }

    private char nextCharacter(char c, char prev){
        if(prev == ((char) (c + 1))){
            return (char) (1 + prev);
        }

        return (char) (1 + c);
    }

    private String getLexicographicalNextString(Stack<Character> stack, int n){
        char lastChar = stack.pop();

        while(!stack.isEmpty() && (lastChar == 'z' || (lastChar == 'y' && stack.peek() == 'z'))){
            lastChar = stack.pop();
        }

        if(lastChar == 'z') return "-1";

        stack.push(nextCharacter(lastChar, stack.peek()));

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        sb.reverse();

        while(sb.length() < n){
            if(sb.charAt(sb.length()-1) > 'a'){
                sb.append('a');
            }
            else{
                sb.append('b');
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println("abcd: " + obj.getSpecialString("abcd"));
        System.out.println("aacd: " + obj.getSpecialString("aacd"));
        System.out.println("abbscd: " + obj.getSpecialString("abbscd"));
        System.out.println("aaaa: " + obj.getSpecialString("aaaa"));
        System.out.println("zzabb: " + obj.getSpecialString("zzabb"));
        System.out.println("abczz: " + obj.getSpecialString("abczz"));
        System.out.println("abcc: " + obj.getSpecialString("abcc"));
        System.out.println("abccss: " + obj.getSpecialString("abccss"));
        System.out.println("zyx: " + obj.getSpecialString("zyx"));
        System.out.println("abbd: " + obj.getSpecialString("abbd"));
        System.out.println("abccdeaaa: " + obj.getSpecialString("abccdeaaa"));
        System.out.println("zyxwvutstuvwxyz: " + obj.getSpecialString("zyxwvutstuvwxyz"));
        System.out.println("zyz: " + obj.getSpecialString("zyz"));
        System.out.println("zyxz: " + obj.getSpecialString("zyxz"));
        System.out.println("zyzyzyz: " + obj.getSpecialString("zyzyzyz"));
    }
}