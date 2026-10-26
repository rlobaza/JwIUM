
package jwium.lab1.messageboard.view;

/**
 * Handles user input from the console.
 * Uses the Display class to show prompts to the user.
 * 
 * <p>Documentation documented with the help of AI (Model: Gemini).
 * 
 * @author Rafal Lobaza
 * @version 1.0
 */
public class DataInput {
    
    /** The display instance used for printing prompts. */
    private final Display display;
    
    /** Scanner object for reading console input streams. */
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
        display.printInTheSameLine("Please write the message's content: ");
        scanner.nextLine();
        return scanner.nextLine();
    }
    
    /**
     * Reads a line from the console and converts it to an integer representing a menu option.
     * 
     * @return the integer option entered by the user
     * @throws java.util.InputMismatchException if the input is not a valid integer (handled internally)
     */
    public int askForMenuOption(){
        while(true)
        {
            display.printInTheSameLine("Choose an option: ");
            try{
                return scanner.nextInt();
            }
            catch(java.util.InputMismatchException exception){
                display.emptyLine();
                display.print("ERROR: Invalid option.");
                display.emptyLine();
                scanner.next();
            }
        }
    }
    
    /**
     * Prompts the user for a message index and adjusts it for zero-based collections.
     * 
     * @return the adjusted zero-based index entered by the user
     * @throws java.util.InputMismatchException if the input is not a valid integer (handled internally)
     */
    public int askForMessageIndex(){
        while(true)
        {
            display.printInTheSameLine("Type the message's index: ");
            try{
                return scanner.nextInt() - 1;
            }
            catch(java.util.InputMismatchException exception){
                display.emptyLine();
                display.print("ERROR: Index must be a valid number.");
                display.emptyLine();
                scanner.next();
            }
        }
    }
    
    /**
     * Prompts the user to enter a description for the message board.
     * 
     * @return the description entered by the user
     */
    public String askForDescription(){
        display.printInTheSameLine("Please write the description for your message board: ");
        return scanner.nextLine();
    }
}
