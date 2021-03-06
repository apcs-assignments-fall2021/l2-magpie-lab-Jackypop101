import java.util.Locale;

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
        return "How is it going my brother from another mother?";
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
        if (findWord(statement,"no") >= 0)
        {
            response = "Why so negative?";
        }
        else if (findWord(statement, "mother") >= 0
                || findWord(statement, "father") >= 0
                || findWord(statement, "sister") >= 0
                || findWord(statement, "brother") >= 0)
        {
            response = "Tell me more about your family.";
        }
        else if (findWord(statement,"cat") >= 0
            || findWord(statement,"dog") >= 0)
        {
            response = "Tell me more about your pets.";
        }
        else if (findWord(statement, "Mr.") >= 0
                || findWord(statement, "Ms.") >= 0
                || findWord(statement, "Mrs.") >= 0)
        {
            response = "They sound like a good teacher";
        }
        else if(statement.trim().length() == 0){
            response = "Say something, please.";
        }
        else if (findWord(statement,"hair") >= 0)
        {
            response = "What do you think about Jack's hair today?";
        }
        else if (findWord(statement, "stress") >= 0)
        {
            response = "Stress is a social construct";
        }
        else if (findWord(statement,"happy") >= 0)
        {
            response = "Happiness is a virtue";
        }
        else if (findWord(statement, "pickup line") >= 0){
            final int NUMBER_OF_RESPONSES = 6;
            double r = Math.random();
            int whichResponse = (int)(r * NUMBER_OF_RESPONSES);

            if (whichResponse == 0)
            {
                System.out.println("Something???s wrong with my eyes because I can???t take them off you.");

            }
            else if (whichResponse == 1)
            {
                System.out.println("If I could rearrange the alphabet, I???d put ???U??? and ???I??? together.");
            }
            else if (whichResponse == 2)
            {
                System.out.println("I'm no photographer, but I can picture us together.");
            }
            else if (whichResponse == 3)
            {
                System.out.println("If you were a Transformer??? you???d be Optimus Fine.");
            }
            else if (whichResponse == 4)
            {
                System.out.println("Hey, my name's Microsoft. Can I crash at your place tonight?");
            }
            else if (whichResponse == 5)
            {
                System.out.println("There is something wrong with my cell phone. It doesn't have your number in it.");
            }
        }
        else if (findWord(statement, "thank you") >= 0){
            System.out.println("My pleasure");
        }
        else if (findWord(statement, "hi") >= 0 || findWord(statement, "hello") >= 0 ){
            System.out.println("Hola");
        }
        else if (findWord(statement, "hate") >= 0){
            response = transformIHatestatement(statement);
        }
        else if (findWord(statement,"want") >= 0){
            response = transformIWantStatement(statement);
        }
        else if (findWord(statement,"want to") >= 0){
            response = transformIWantStatement(statement);
        }
        else if (findWord(statement, "you")>=0){
            if ((findWord(statement, "me"))>(findWord(statement, "you"))){
                response = transformYouMeStatement(statement);
            }
            else if (findWord(statement, "I")<(findWord(statement, "you"))) {
                response = transformIYouStatement(statement);
            }
            else{
                response = getRandomResponse();
            }
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
//        char j = Character.toUpperCase(word.charAt(0));
//        char g = Character.toLowerCase(word.charAt(0));
//        String x = j + word.substring(1, word.length()-1);
//        String y = g + word.substring(1, word.length()-1);
        str = str.toLowerCase();
        String x = word.toLowerCase();
        String word1 = " " + x + " ";
        String word2 = x + " ";
        String word3 = " " + x;

        if ((str.indexOf(word))>= 0) {
            if (str.indexOf(word1) >= 0) {
                return str.indexOf(word1) + 1;
            } else if (str.indexOf(word2) == 0) {
                return str.indexOf(word2);
            } else if (str.indexOf(word3) == str.length() - word.length() - 1) {
                return str.indexOf(word3) + 1;
            } else {
                return -1;
            }
        }
        else {
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
        int j = findWord(statement, "I want");
        String x = statement.substring(j + 8, statement.length());
        String o = "Would you really be happy if you had " + x + "?";
        return o;
    }

    /**
     * Take a statement with "I <something> you" and transform it into 
     * "Why do you <something> me?"
     * @param statement the user statement, assumed to contain "I" followed by "you"
     * @return the transformed statement
     */
    public String transformIYouStatement(String statement)
    {
        int j = findWord(statement, "I");
        int a = findWord(statement, "you");
        String x = statement.substring(j + 3,a);
        String o = "Why do you " + x + "me?";
        return o;
    }

    /**
     * Take a statement with "I want to <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    public String transformIWantToStatement(String statement)
    {
        int j = findWord(statement, "I want to");
        String x = statement.substring(j + 11, statement.length());
        String o = "What would it mean to " + x + "?";
        return o;
    }




    /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    public String transformYouMeStatement(String statement)
    {
        int j = findWord(statement, "you");
        int a = findWord(statement, "me");
        String x = statement.substring(j + 4,a);
        String o = "What makes you think that I " + x + "you?";
        return o;
    }
    public String transformIHatestatement(String statement){
        int j = findWord(statement, "I hate");
        String x = statement.substring(j + 8, statement.length());
        String o = "Why do you hate " + x + "?";
        return o;
    }


}
