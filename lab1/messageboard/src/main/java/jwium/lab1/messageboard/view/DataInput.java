
package jwium.lab1.messageboard.view;

/**
 * Handles user input from the console.
 * Uses the Display class to show prompts to the user.
 */
public class DataInput {
    Display display;
    java.util.Scanner scanner = new java.util.Scanner(System.in);
    
    /**
     * Creates a DataInput object connected to the specified display.
     *
     * @param initialDisplay the display used to show messages to the user
     */
    public DataInput(Display initialDisplay){
        display = initialDisplay;
    }
    
    /**
     * Prompts the user to enter the content of a new message
     * and reads the input from the console.
     *
     * @return the content entered by the user
     */
    public String askForMessageContent(){
        display.print("Please write the message's content: ");
        String messageContent = scanner.nextLine();
        return messageContent;
    }
    
    /**
     * Reads a line from the console and converts it to an integer.
     *
     * @return the integer entered by the user
     * @throws NumberFormatException if the input is not a valid integer
     */
    public int inputInteger(){
        String integerString = scanner.nextLine();
        return Integer.parseInt(integerString);
    }
}
