/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *          Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie
{
    /**
     * Get a default greeting   
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        if (statement.indexOf("no") >= 0)
        {
            response = "Why so negative?";
        }
        else if (statement.indexOf("mother") >= 0
                || statement.indexOf("father") >= 0
                || statement.indexOf("sister") >= 0
                || statement.indexOf("brother") >= 0)
        {
            response = "Tell me more about your family.";
        }
        else if (statement.indexOf("cat") >= 0
            || statement.indexOf("dog") >= 0)
        {
            response = "Tell me more about your pets.";
        }
        else if (statement.indexOf("Mr.") >= 0
                || statement.indexOf("Ms.") >= 0
                || statement.indexOf("Mrs.") >= 0)
        {
            response = "They sound like a good teacher";
        }
        else if(statement.trim().length() == 0){
            response = "Say something, please.";
        }
        else if (statement.indexOf("hair") >= 0)
        {
            response = "What do you think about Jack's hair today?";
        }
        else if (statement.indexOf("stress") >= 0)
        {
            response = "Stress is a social construct";
        }
        else if (statement.indexOf("happy") >= 0)
        {
            response = "Happiness is a virtue";
        }
        else if (statement.substring(0, 6) == "I want " ){
            response = transformIWantStatement(statement);
        }
        else
        {
            response = getRandomResponse();
        }
        return response;
    }
    
    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    public String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 6;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }
        else if (whichResponse == 4)
        {
            response = "Fascinating!";
        }
        else if (whichResponse == 5)
        {
            response = "Some people like that";
        }

        return response;
    }

    // Checks to see if the String word appears as a whole word
    // in the String str (in this case, a "whole word" means that 
    // word is not just a substring of some larger word in str)

    // This method should work regardless of the capitalization 
    // of str or word

    // The method returns the index of the first character in word
    // if it is found, and returns -1 otherwise. 
    public int findWord(String str, String word) {
        char j = Character.toUpperCase(word.charAt(0));
        char g = Character.toLowerCase(word.charAt(0));
        String x = j + word.substring(1, word.length()-1);
        String y = g + word.substring(1, word.length()-1);
        String word1 = " " + x + " ";
        String word1y = " " + y + " ";
        String word2 = x + " ";
        String word2y = y + " ";
        String word3 = " " + x;
        String word3y = " " + y;
        if (str.indexOf(word1) >= 0 || str.indexOf(word1y) >= 0)
        {
            return str.indexOf(word1) + 1;
        }
        else if (str.indexOf(word2) == 0 || str.indexOf(word2y) == 0)
        {
            return str.indexOf(word2);
        }
        else if (str.indexOf(word3) == str.length()-word.length() || str.indexOf(word3y) == str.length()-word.length())
        {
            return str.indexOf(word3) + 1;
        }
        else{
            return -1;
        }
    }

    
    // We will work on the following methods later!

    /**
     * Take a statement with "I want <something>." and transform it into 
     * "Would you really be happy if you had <something>?"
     * @param statement the user statement, assumed to contain "I want"
     * @return the transformed statement
     */
    public String transformIWantStatement(String statement)
    {
        String x = statement.substring(7, statement.length()-1);
        return "Would you really be happy if you had " + x;
    }

    /**
     * Take a statement with "I <something> you" and transform it into 
     * "Why do you <something> me?"
     * @param statement the user statement, assumed to contain "I" followed by "you"
     * @return the transformed statement
     */
    public String transformIYouStatement(String statement)
    {
        //your code here
        return "";
    }

    /**
     * Take a statement with "I want to <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    public String transformIWantToStatement(String statement)
    {
        // your code here
        return "";
    }




    /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    public String transformYouMeStatement(String statement)
    {
        // your code here
        return "";
    }
}
