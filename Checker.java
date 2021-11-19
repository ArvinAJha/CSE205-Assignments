//Assignment #: 11
//Name: Arvin Jha
//StudentID: 1221497264
//Lecture: 10:10AM - 11:00AM M W F
// Description: Checker has one method check that reads a String line to determine if all of the braces are present
                //and returns a custom message if they are all present or if there any missing

import java.util.EmptyStackException;
import java.util.Stack;

public class Checker {

    /**
     * The check method reads a line and checks through that line for any missing braces and returns a message
     * indicating where the missing braces are
     * @param lineToCheck
     * @return message indicating whether there are missing braces and where 
     */
    public static String check(String lineToCheck) {

        //create stack
        Stack<String> aStack = new Stack<String>();

        //split line into individual characters
        String[] letters = lineToCheck.split("");

        //loop through each character
        for(int i = 0; i < letters.length; i++) {

            //when there are opening braces, add them into the stack
            if(letters[i].equals("(")) {
                aStack.push("A");
            } else if(letters[i].equals("[")) {
                aStack.push("B");
            } else if(letters[i].equals("{")) {
                aStack.push("C");
            }

            //when there are closing braces
            if(letters[i].equals(")")) {

                try {

                    if(aStack.peek().equals("A")) {                     //and there is a matching opening, pop the stack
                        aStack.pop();
                    } else {
                        return ") at the position " + i + " does not match.";   //there is not a matching brace, return error
                    }

                } catch (EmptyStackException e) {                       //catch error where closing brace is at the front of line
                    return ") at the position " + i + " does not match.";
                }

            } else if(letters[i].equals("]")) {

                try {

                    if(aStack.peek().equals("B")) {                     //there is a matching opening, pop the stack
                        aStack.pop();
                    } else {
                        return "] at the position " + i + " does not match.";   //there is not a matching brace, return error
                    }

                } catch (EmptyStackException e) {                       //catch error where closing brace is at the front of line
                    return "] at the position " + i + " does not match.";
                }

            } else if(letters[i].equals("}")) {

                try {

                    if(aStack.peek().equals("C")){                     //there is a matching opening, pop the stack
                        aStack.pop();
                    } else {
                        return "} at the position " + i + " does not match.";   //there is not a matching brace, return error
                    }

                } catch (EmptyStackException e) {                       //catch error where closing brace is at the front of line
                    return ") at the position " + i + " does not match.";
                }

            }
        }

        //must check if there are any opening braces left after having traversed the entire line
        try {

            //if there are opening braces, return missing
            if(aStack.peek().equals("A")) {

                return ") is missing.";

            } else if(aStack.peek().equals("B")) {

                return "] is missing.";

            } else if(aStack.peek().equals("C")) {

                return "} is missing.";

            }

        } catch (EmptyStackException e) {                   //catch error where stack is empty because there is nothing missing
            return "Everything is matched!";
        }

        return "Everything is matched!";    //default return statement 
    }

}
