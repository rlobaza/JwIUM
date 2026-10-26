
package jwium.lab1.messageboard.view;
import jwium.lab1.messageboard.model.*;

/**
 * Handles the presentation of information to the user.
 * Displays messages, menu options, and other text in the console.
 * 
 * <p>Documentation documented with the help of AI (Model: Gemini).
 * 
 * @author Rafal Lobaza
 * @version 1.0
 */
public class Display {
    
    /**
     * Creates a new Display object.
     */
    public Display(){
        
    }
    
    /**
     * Prints all messages stored in the message manager.
     * Each message is preceded by its position in the list,
     * starting from 1.
     * 
     * @param manager the manager containing the messages to display
     */
    public void printAllMessages(MessagesManager manager){
        print("###################################");
        print("---------- MESSAGES ----------");
        for(int i = 0; i < manager.getMessages().size(); i++){
            System.out.print(String.valueOf(i + 1) + " ");
            System.out.println(manager.getMessages().get(i).getContent());
        }
        print("###################################");
    }
    
    /**
     * Prints the specified text followed by a new line.
     * 
     * @param text the text to print
     */
    public void print(String text){
        System.out.println(text);
    }
    
    /**
     * Prints the specified text in the same line without trailing newline.
     * 
     * @param text the text to print
     */
    public void printInTheSameLine(String text){
        System.out.print(text);
    }
    
    /**
     * Prints an empty line to the console.
     */
    public void emptyLine(){
        System.out.println();
    }
    
    /**
     * Displays the main menu with the available application options.
     */
    public void printMainMenu()
    {
        print("###################################");
        print("---------- MESSAGE BOARD ----------");
        print("1 - View all messages");
        print("2 - Show description");
        print("3 - Post a new message");
        print("4 - Delete a message");
        print("5 - Exit");
        print("###################################");
    }
    
    /**
     * Displays the board description wrapped in decorative borders.
     * 
     * @param description the description text to display
     */
    public void printDescription(String description)
    {
        print("###################################");
        print("---------- DESCRIPTION ----------");
        print(description);
        print("###################################");
    }
}
